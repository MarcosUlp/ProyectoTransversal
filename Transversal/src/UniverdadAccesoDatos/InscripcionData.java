/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniverdadAccesoDatos;

import UniversidadEntidades.Inscripcion;
import UniversidadEntidades.Materia;
import UniversidadEntidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel Sosa
 */
public class InscripcionData {

    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    private Connection con;
    // private AlumnoData aluData;
    // private MateriaData matData;

    public InscripcionData() {

    }

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES ( ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //  ps.setInt(1, insc.getIdInscripcion());
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción Registrada");
                System.out.println("Inscripción guardada exitosamente.");
            } else {
                System.out.println("Error al guardar la inscripción.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }
    }

    List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion in = new Inscripcion();
                in.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
                in.setAlumno(alu);
                in.setMateria(mat);
                in.setNota(rs.getDouble("nota"));
                cursadas.add(in);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return cursadas;
    }

    List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion WHERE = idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, idAlumno);
            
            while (rs.next()) {
                Inscripcion in = new Inscripcion();
                in.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
                in.setAlumno(alu);
                in.setMateria(mat);
                in.setNota(rs.getDouble("nota"));
                cursadas.add(in);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        return cursadas;

    }

    List<Materia> obtenerMateriasCursadas(int idAlumno) {
        
        ArrayList <Materia> materias = new ArrayList<>();
        
        String sql= "SELECT  inscripcion.idMateria, nombre, año, FROM inscripcion,"+
                    "materia WHERE inscripcion.idMateria = materia.idMateria" +
                    "AND inscripcion.idAlumno=?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla materia");
        }
        return materias;
    }

    List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        
        ArrayList <Materia> materias = new ArrayList<>();
        
        String sql = "SELECT * FROM materia WHERE estado = 1AND idMateria not in "+
                    "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Inscripciones");
        }
        return materias;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? and idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción Borrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }

    }

    List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT a.idAlumno, dni, nombre, apellido,fechaNacimiento,estado "+
                    "FROM inscripcion i,alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";
        try{
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaDeNacimiento(rs.getDate("fechaDeNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
        
        
        return alumnos;
    }
}
