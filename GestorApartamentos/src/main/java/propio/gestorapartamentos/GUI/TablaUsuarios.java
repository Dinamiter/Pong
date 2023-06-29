/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package propio.gestorapartamentos.GUI;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import propio.gestorapartamentos.DTO.Usuario;
import propio.gestorapartamentos.DataAcess.AccesoDatos;

/**
 *
 * @author anton
 */
public class TablaUsuarios extends javax.swing.JDialog {

    /**
     * Creates new form TablaUsuarios
     * @param parent
     * @param modal
     */
    static FramePrincipal fp;
    AccesoDatos ad=new AccesoDatos();
    
    public TablaUsuarios(JDialog parent, boolean modal) {
        //super(parent, modal);
        initComponents();
        
         this.setBounds(400, 10, 400, 400);
        this.setBackground(Color.red);
         inicializa();
         cargarTablaUsuarios();
         //this.add(TablaDeUsuarios);
         //TablaDeUsuarios.setVisible(true);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDeUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TablaDeUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(TablaDeUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void inicializa()
    {
        String camposTabla[] = {"Id", "Email", "Pass"};
        DefaultTableModel modelo = new DefaultTableModel(null, camposTabla);
        TablaDeUsuarios.setModel(modelo);
    }
    
     void cargarTablaUsuarios()
    {
        
System.out.println("esta en cargarTablaUsuarios");
        try {
            String campos[] = {"Id", "Email", "Password"};
            DefaultTableModel modelo = new DefaultTableModel(null, campos);
            modelo.setColumnIdentifiers(campos);

            ArrayList<Usuario> usuarios = ad.getUsuarios();

            String filas[] = new String[3];
            for (Usuario u : usuarios) {
       
                int num=u.getId();
                filas[0] = Integer.toString(num);
                filas[1] = u.getEmail();
                filas[2] = u.getPassword();

                modelo.addRow(filas);
            }

            TablaDeUsuarios.setModel(modelo);

        } catch (Exception e) {
        }
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                var dialog = new TablaUsuarios(new DialogLogin(fp,true), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDeUsuarios;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
