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
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel Sosa
 */
public class InscripcionData {

    private Connection con;
    private AlumnoData aluData;
    private MateriaData matData;

    public InscripcionData() {
    }

    public void guardarInscripcion(Inscripcion insc) { 
        String sql = "INSERT INTO inscripcion(idInscripto, nota, idAlumno, idMateria) VALUES ( ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
          //  ps.setInt(1, insc.getIdInscripcion());
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inscripción guardada exitosamente.");
            } else {
                System.out.println("Error al guardar la inscripción.");
            }
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }
    }

    List<Inscripcion> obtenerInscripciones() {
        return null;
    }

    List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        return null;
    }

    List<Materia> obtenerMaterias(int id) {
        return null;
    }

    List<Materia> obtenerMateriasNOcursadas(int id) {
        return null;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumnom, int idMateria) {
    }

    public void actualizarNota(int idAlumnom, int idMateria, double nota) {

    }

    List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        return null;
    }
}
