package propio.gestorapartamentos.GUI;

import java.awt.Color;
import java.io.IOException;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import propio.gestorapartamentos.DTO.Apartamento;
import propio.gestorapartamentos.DTO.Usuario;
import propio.gestorapartamentos.DataAcess.AccesoDatos;

/**
 *
 * @author anton
 */
public class FramePrincipal extends javax.swing.JFrame {

    DialogLogin log;
    PanelTablaApartamentos pta;
    
    
    int numId;
    List<Apartamento> apartamentos;
    AccesoDatos ad;
    
    
    
    

    public FramePrincipal() {
        initComponents();

        this.setSize(520, 520);
        this.getDefaultCloseOperation();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(BotonMostrarApartamentos);
        BotonMostrarApartamentos.setVisible(false);
        //removeAll();
         this.getContentPane().add(Content);
         Content.setVisible(false);
         
        
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Content = new javax.swing.JPanel();
        EtiquetaWeb = new javax.swing.JLabel();
        BotonLogin = new javax.swing.JButton();
        BotonMostrarApartamentos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        Content.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Content.setMinimumSize(new java.awt.Dimension(500, 410));
        Content.setName(""); // NOI18N
        Content.setPreferredSize(new java.awt.Dimension(500, 410));
        Content.setLayout(null);
        getContentPane().add(Content);
        Content.setBounds(2, 53, 500, 400);

        EtiquetaWeb.setBackground(new java.awt.Color(255, 153, 153));
        EtiquetaWeb.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        EtiquetaWeb.setText("           WWW.TUALQUILER.COM");
        EtiquetaWeb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(EtiquetaWeb);
        EtiquetaWeb.setBounds(80, 10, 320, 37);

        BotonLogin.setBackground(new java.awt.Color(255, 153, 153));
        BotonLogin.setText("LOGIN");
        BotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(BotonLogin);
        BotonLogin.setBounds(190, 160, 103, 37);

        BotonMostrarApartamentos.setText("Mostrar apartamentos");
        BotonMostrarApartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMostrarApartamentosActionPerformed(evt);
            }
        });
        getContentPane().add(BotonMostrarApartamentos);
        BotonMostrarApartamentos.setBounds(160, 100, 160, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarLogin(){
        log = new DialogLogin(this, true);
        log.setVisible(true);
        comprobarId();
        //BotonMostrarApartamentos.setVisible(true);  
    }
    
    
  
    public void comprobarId(){
        numId=log.pasarId();
        System.out.println("esto es comprobarId():********************* "+numId);
        if(numId>0) {    
            BotonMostrarApartamentos.setVisible(true);
        }
    }
    
    public void quitarBotones(){
        BotonMostrarApartamentos.setVisible(false);
        BotonLogin.setVisible(false);
    }
    
    public void cargarApartamentos() {
       
        if (numId> 0) {
         
            
            try {
         
                pta = new PanelTablaApartamentos(ad.getMunicipios(numId),this);
                pta.setSize(490,490);
                pta.setLocation(5,50);
                Content.add(pta);
                Content.setBackground(Color.white);
                Content.setVisible(true);
                quitarBotones();
              /*
                Content.removeAll(); 
                Content.add(pta);
                pta.setVisible(true);
                Content.revalidate();
                Content.repaint();
               */ 
                
                
            } catch (IOException ex) {
                Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } 
    }
    
    private void BotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLoginActionPerformed
              
        cargarLogin();
     
            //JOptionPane.showMessageDialog(rootPane, "Usuario erroneo");
    }//GEN-LAST:event_BotonLoginActionPerformed

    private void BotonMostrarApartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMostrarApartamentosActionPerformed
     //removeAll();
     
        cargarApartamentos();
        
    }//GEN-LAST:event_BotonMostrarApartamentosActionPerformed

    public int login(String email, String contrasenia) throws IOException, SQLException {

        String sentenciaSql = ("SELECT * FROM usuari WHERE email='" + email + "' AND password='" + contrasenia + "' ");
        ad = new AccesoDatos();
        try {
            Statement st = ad.conectarBD().createStatement();
            ResultSet rs = st.executeQuery(sentenciaSql);
            Usuario usuari = new Usuario();

            if (rs.next()) {
                usuari.setId(rs.getInt("id"));
                numId = rs.getInt("id");
                System.out.println("Acceso permitido al usuario id: " + usuari.getId());
                return numId;
            }
        } catch (SQLException e) {
            System.out.println("Error de conexion:" + e.getSQLState());
            System.out.println("Usuario o contraseña erroneos");
            JOptionPane.showMessageDialog(rootPane, "Usuario erroneo");
        }
        return 0;
    }
    

    
    
    void pasarId(int id) {
        numId=id;
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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLogin;
    private javax.swing.JButton BotonMostrarApartamentos;
    private javax.swing.JPanel Content;
    private javax.swing.JLabel EtiquetaWeb;
    // End of variables declaration//GEN-END:variables

    
    

    
}
