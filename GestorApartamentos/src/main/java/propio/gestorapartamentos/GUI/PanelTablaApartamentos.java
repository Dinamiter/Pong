/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package propio.gestorapartamentos.GUI;


import java.awt.Color;

import java.util.List;
import propio.gestorapartamentos.DTO.Apartamento;
import propio.gestorapartamentos.TableModel.ModeloTabla;


/**
 *
 * @author anton
 */
public class PanelTablaApartamentos extends javax.swing.JPanel {

    private FramePrincipal fp;
    private List <Apartamento>apartamentos;
    ModeloTabla mt;
    /**
     * Creates new form PanelTablaApartamentos
     * 
     * 
     * @param apartamentos
     * @param fp
     */
 
    public PanelTablaApartamentos(List<Apartamento>apartamentos, FramePrincipal fp) {
        initComponents();
        this.fp = fp;
        this.apartamentos=apartamentos;
        this.setBackground(Color.lightGray);
        cargaTablaApartamentos();
     
    }

    private void cargaTablaApartamentos(){
        mt=new ModeloTabla(apartamentos);
        TablaApartamentos.setModel(mt);
    
    }
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaApartamentos = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setAlignmentX(getAlignmentX());
        setAlignmentY(getAlignmentY());
        setPreferredSize(new java.awt.Dimension(490, 490));
        setRequestFocusEnabled(false);
        setLayout(null);

        TablaApartamentos.setBackground(new java.awt.Color(153, 153, 153));
        TablaApartamentos.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        TablaApartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaApartamentos.setPreferredSize(new java.awt.Dimension(500, 410));
        jScrollPane1.setViewportView(TablaApartamentos);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 100, 500, 110);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaApartamentos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
