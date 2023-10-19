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
           
    private final Connection con ;

    public MateriaData() {
        
        con = Conexion.getConexion();
        
    }
    
    public void agregarMateria (Materia materia){
        
        String query = "INSERT INTO materia (nombre,anio,estado) VALUES (?,?,?);";
          
        try{
            PreparedStatement st = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            st.setString(1, materia.getNombre());
            st.setInt(2, materia.getAnioMateria());
            st.setBoolean(3,materia.isActivo() );

            st.executeUpdate();

            ResultSet resultado = st.getGeneratedKeys();
            
            if(resultado.next()){
                materia.setIdMateria(resultado.getInt(1));
            }
            
            JOptionPane.showMessageDialog(null, "La Materia se guardo correctamente");
            
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null,"Error al guardar Materia ");
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e.getMessage() );
            }
            }
    
    
}
