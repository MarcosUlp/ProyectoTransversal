/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniverdadAccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel Sosa
 */
public class Conexion {

    private static final String DATABASE_URL = "jdbc:mariadb://";
    private static final String DATABASE_HOST = "localhost";
    private static final String DATABASE_PUERTO = ":3306";
    private static final String DATABASE_DB = "/univesidadg3";
    private static final String DATABASE_USUARIO = "root";
    private static final String DATABASE_PASSWORD = "";
    private static Conexion conexion = null;

    private Conexion() {
        try {
            //Cargar drivers
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver" + ex);
        }
    }

    public static Connection getConexion() {
        Connection con = null;

        if (conexion == null) {
            conexion = new Conexion();

            try {

                con = DriverManager.getConnection(
                        DATABASE_URL
                        + DATABASE_HOST
                        + DATABASE_PUERTO
                        + DATABASE_DB
                        + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user="
                        + DATABASE_USUARIO
                        + "&password="
                        + DATABASE_PASSWORD
                );
                JOptionPane.showMessageDialog(null,"conectado");
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
            }
        }
        return con;
    }
}

//    private static final String URL = "jdbc:mariadb://localhost:3306/univesidadg3";
//    private static final String usuario = "root";
//    private static final String password = "";
//
//    private static Connection connection;
//
//    Conexion() {
//    }
//
//    public static Connection getConexion() {
//        if (connection == null) {
//            try {
//                Class.forName("org.mariadb.jdbc.Driver");
//                Connection con = DriverManager.getConnection(URL, usuario, password);
//
//            } catch (ClassNotFoundException ex) {
//                JOptionPane.showMessageDialog(null, "Error al cargar Driver");
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error de conexión");
//
//                int error = ex.getErrorCode();
//                ex.printStackTrace();
//
//                if (error == 1146) {
//                    JOptionPane.showMessageDialog(null, "Tabla inexistente");
//                } else if (error == 1062) {
//                    JOptionPane.showMessageDialog(null, "Dni duplicado");
//                } else if (error == 1049) {
//                    JOptionPane.showMessageDialog(null, "BD inexistente");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error SQL");
//                }
//            }
//            return connection
//        }

