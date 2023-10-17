/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniverdadAccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel Sosa
 */
public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "univesidadg3";
    private static final String usuario = "root";
    private static final String password = "";

    public static Connection connection;

    private Conexion() {
    }
    
    public static Connection getConexion(){
    if(connection==null){
            try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL+DB, usuario, password);
            JOptionPane.showMessageDialog(null, "conectado");
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión");

            int error = ex.getErrorCode();
            ex.printStackTrace();
            
            if (error == 1146) {
                JOptionPane.showMessageDialog(null, "Tabla inexistente");
            } else if (error == 1062) {
                JOptionPane.showMessageDialog(null, "Dni duplicado");
            } else if (error == 1049) {
                JOptionPane.showMessageDialog(null, "BD inexistente");
            } else {
                JOptionPane.showMessageDialog(null, "Error SQL");
            }
        }
    }
             return connection;
    }
}
