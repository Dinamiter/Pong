package propio.gestorapartamentos.GUI;

import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import propio.gestorapartamentos.DataAcess.AccesoDatos;
import propio.gestorapartamentos.GUI.*;

/**
 *
 * @author anton
 */
public class DialogLogin extends javax.swing.JDialog {

    AccesoDatos ad = new AccesoDatos();
    Connection con;
    FramePrincipal fp;
    int id,numId;
    TablaUsuarios tu;

    public DialogLogin(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
        initComponents();
        
        fp=(FramePrincipal)parent;

        this.setLocationRelativeTo(null);
        BotonEntrarLogin.setEnabled(true);
        
        
        TextFieldNombre.setText("scramer0@1688.com");
        TextFieldPass.setText("cp5WhK");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonEntrarLogin = new javax.swing.JButton();
        TextFieldNombre = new javax.swing.JTextField();
        TextFieldPass = new javax.swing.JTextField();
        EtiquetaUsuario = new javax.swing.JLabel();
        EtiquetaPass = new javax.swing.JLabel();
        BotonConectar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        BotonEntrarLogin.setBackground(new java.awt.Color(153, 153, 255));
        BotonEntrarLogin.setText("Login");
        BotonEntrarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEntrarLoginActionPerformed(evt);
            }
        });

        EtiquetaUsuario.setText("Usuario");

        EtiquetaPass.setText("Contraseña");

        BotonConectar.setText("Prueba Conex.BD");
        BotonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConectarActionPerformed(evt);
            }
        });

        jButton1.setText("TablaUsers");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldNombre)
                            .addComponent(TextFieldPass, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotonConectar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(BotonEntrarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(EtiquetaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtiquetaPass, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(EtiquetaUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(EtiquetaPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonEntrarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void BotonEntrarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEntrarLoginActionPerformed
             
        String email=TextFieldNombre.getText();
        String pass=TextFieldPass.getText();
        
        try {
            id=fp.login(email, pass);
            System.out.println("valor id en login"+ numId);
            
            //hacer el metodo 
            if (id>0){
               pasarId();
                System.out.println("dentro del if del login si id>0 --justo antes del pasarId()");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(DialogLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DialogLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        fp.comprobarId(); 
        this.dispose();
        
    }//GEN-LAST:event_BotonEntrarLoginActionPerformed

    public int pasarId(){
        System.out.println("este es el valor de id en pasarId()"+ id);
    return id;
    }
    
    
    private void BotonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConectarActionPerformed
      
        try {
            con=ad.conectarBD();
            if(con!=null)
            {
                System.out.println("Conexion establecida");
                BotonEntrarLogin.setEnabled(true);
            }
        } catch (IOException ex) {
            System.out.println("Error en la concexión(dialoglogin)");
        }
        
        
    }//GEN-LAST:event_BotonConectarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        tu=new TablaUsuarios(this, true);
        tu.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonConectar;
    private javax.swing.JButton BotonEntrarLogin;
    private javax.swing.JLabel EtiquetaPass;
    private javax.swing.JLabel EtiquetaUsuario;
    private javax.swing.JTextField TextFieldNombre;
    private javax.swing.JTextField TextFieldPass;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
