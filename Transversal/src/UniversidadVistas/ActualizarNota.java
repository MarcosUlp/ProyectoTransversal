/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadVistas;

import UniverdadAccesoDatos.AlumnoData;
import UniverdadAccesoDatos.InscripcionData;
import UniverdadAccesoDatos.MateriaData;
import UniversidadEntidades.Alumno;
import UniversidadEntidades.Inscripcion;
import UniversidadEntidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Marcos
 */
public class ActualizarNota extends javax.swing.JInternalFrame {

    private AlumnoData ad = new AlumnoData();
    private MateriaData md = new MateriaData();
    private InscripcionData id = new InscripcionData();
    private List<Alumno> ListaAlumnos = ad.listarAlumnos();
    private List<Materia> ListaMaterias = new ArrayList<>();
    private List<Inscripcion> listaincripcion = new ArrayList<>();
    private DefaultComboBoxModel comboModelA = new DefaultComboBoxModel(ListaAlumnos.toArray());
    private DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form Inscripciones
     */
    public ActualizarNota() {
        initComponents();
        armarCabecera();
        llenarCBAlumnos();
      //  SelectInscripto();
      //  jrInscriptas.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcSelecAlumno = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Actualizar Nota");

        jLabel2.setText("Seleccione un alumno");

        jcSelecAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcSelecAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcSelecAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setText("Listado de Materias");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jbInscribir.setText("Actualizar");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbInscribir)
                        .addGap(103, 103, 103)
                        .addComponent(jButton3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(175, 175, 175))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jButton3)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(jcSelecAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcSelecAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        // TODO add your handling code here:
//        Alumno al = (Alumno) jcSelecAlumno.getSelectedItem();
//        int filaSeleccionada = jTable.getSelectedRow();
//
//        TableModel model = jTable.getModel();
//
//        if (filaSeleccionada != -1) {
//
//            Integer id_Materia = (Integer) model.getValueAt(filaSeleccionada, 0);
//            String nombre = (String) model.getValueAt(filaSeleccionada, 1);
//            Integer anio = (Integer) model.getValueAt(filaSeleccionada, 2);
//
//            Materia m = new Materia(id_Materia, nombre, anio, true);
//
//            Inscripcion i = new Inscripcion(al, m, 0);
//            id.guardarInscripcion(i);
//            JOptionPane.showMessageDialog(null, "Alumno inscripto correctamente");
//            SelectNoInscripto();
//        } else {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
//        }
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jcSelecAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSelecAlumnoActionPerformed
      SelectInscripto();
    }//GEN-LAST:event_jcSelecAlumnoActionPerformed
//    public void SelectNoInscripto() {
//        modelo.setRowCount(0);
//        jbAnular.setEnabled(false);
//        jbInscribir.setEnabled(true);
//        jrInscriptas.setSelected(false);
//        Alumno al = (Alumno) jcSelecAlumno.getSelectedItem();
//        ListaMaterias = id.obtenerMateriasNoCursadas(al.getIdAlumno());
//        Materia m = new Materia();
//        for (Materia aux : ListaMaterias) {
//            modelo.addRow(new Object[]{aux.getIdMateria(), aux.getNombre(), aux.getAnioMateria()});
//        }
//    }

    public void SelectInscripto() {

        modelo.setRowCount(0);
     //   jbAnular.setEnabled(true);
        jbInscribir.setEnabled(false);
       // jrNoInscriptos.setSelected(false);
        Alumno al = (Alumno) jcSelecAlumno.getSelectedItem();
      ListaMaterias = id.obtenerMateriasCursadas(al.getIdAlumno());
       //listaincripcion = 
        Materia m = new Materia();
        for (Materia aux : ListaMaterias) {
            modelo.addRow(new Object[]{aux.getIdMateria(), aux.getNombre(), aux.getAnioMateria()});
        }
        //jrInscriptas.setSelected(true);
    }

    public void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("id");
        filaCabecera.add("Nombre");
        filaCabecera.add("Año");
        filaCabecera.add("Nota");
        for (Object i : filaCabecera) {
            modelo.addColumn(i);
        }
        jTable.setModel(modelo);
    }
    public void llenarCBAlumnos(){
        jcSelecAlumno.setModel(comboModelA);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JComboBox<String> jcSelecAlumno;
    // End of variables declaration//GEN-END:variables

     public void Limpiar() {
        modelo.setRowCount(0);
    }
}
