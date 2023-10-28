/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniverdadAccesoDatos;

import UniversidadEntidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel Sosa
 */
public class MateriaData {

    private final Connection con;

    public MateriaData() {

        con = Conexion.getConexion();

    }

    public void agregarMateria(Materia materia) {

        String query = "INSERT INTO materia (nombre,anio,estado) VALUES (?,?,?);";

        try {
            PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, materia.getNombre());
            st.setInt(2, materia.getAnioMateria());
            st.setBoolean(3, materia.isActivo());

            st.executeUpdate();

            ResultSet resultado = st.getGeneratedKeys();

            if (resultado.next()) {
                materia.setIdMateria(resultado.getInt(1));
                JOptionPane.showMessageDialog(null, "La Materia se guardo correctamente");
            }

            st.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al guardar Materia ");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
    }

    public void eliminarMateria(int id) { 
        try {
            String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó la materia.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla materia");
        }
    }

    public Materia buscarMateria(int id) { //PROBADO Por Arian ;)
        String sql = "SELECT idMateria, nombre, anio, estado FROM materia WHERE idMateria = ?";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "La materia exite");
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materia.setActivo(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la materia");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia " + ex.getMessage());
            return materia;
        }
        return materia;
    }

}
