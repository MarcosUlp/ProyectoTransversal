/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transversal;

import UniverdadAccesoDatos.AlumnoData;
import UniverdadAccesoDatos.Conexion;
import UniversidadEntidades.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import UniverdadAccesoDatos.Conexion;
/**
 *
 * @author Marcos
 */
public class Transversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AlumnoData a = new AlumnoData();
        Connection con = Conexion.getConexion();
        Alumno alum2=new Alumno(123456, "marcos", "sosa", LocalDate.of(2000,5,31), true);
        System.out.println(alum2);
        System.out.println("coneccion "+con);
        a.guardarAlumno(alum2);
        System.out.println(con);
//        try {
//
//            Cargo Driver de conexión
//            Class.forName("org.mariadb.jdbc.Driver");
//
//            Establecer la conexión
//            String URL = "jdbc:mariadb://localhost:3306/univesidadg3";
//            String usuario = "root";
//            String password = "";
//            Connection con = DriverManager.getConnection(URL, usuario, password);
//---------------------------------------------------------------------------------------------------------------------------------------------------------            
//            int filas = ps.executeUpdate();
//                if (filas > 0) {
//                    JOptionPane.showMessageDialog(null, "datos Agregados");
//                }
//            }catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "Error al cargar Driver");
//        }catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error de conexión");
//
//            int error = ex.getErrorCode();
//           ex.printStackTrace();
//            if (error == 1146) {
//                JOptionPane.showMessageDialog(null, "Tabla inexistente");
//            } else if (error == 1062) {
//                JOptionPane.showMessageDialog(null, "Dni duplicado");
//            } else if (error == 1049) {
//                JOptionPane.showMessageDialog(null, "BD inexistente");
//            } else {
//                JOptionPane.showMessageDialog(null, "Error SQL");
//            }
//        }
    }
    
}
