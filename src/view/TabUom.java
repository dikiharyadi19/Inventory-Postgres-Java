/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UomController;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


/**
 *
 * @author Dikki Haryadi
 */
public class TabUom extends javax.swing.JPanel {
    private final UomController uomController=new UomController();
  
    /**
     * Creates new form TabUom
     */
    public TabUom() {
        initComponents();
        uomController.UpdateTable(tableUom);
        uomController.setId(fieldId, tableUom);
        fieldName.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tableUom = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDescription = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldAbbreviation = new javax.swing.JTextField();
        fieldSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        fieldId = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableUom.setForeground(new java.awt.Color(0, 0, 0));
        tableUom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Abbreviation", "Description"
            }
        ));
        tableUom.setSelectionBackground(new java.awt.Color(249, 84, 55));
        tableUom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUomMouseClicked(evt);
            }
        });
        tableUom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableUomKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tableUom);

        jPanel2.setBackground(new java.awt.Color(187, 187, 187));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Keterangan");

        areaDescription.setColumns(20);
        areaDescription.setRows(5);
        jScrollPane1.setViewportView(areaDescription);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nama Satuan");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Satuan*");

        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldSearchKeyReleased(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(187, 187, 187));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Refresh");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldName)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldAbbreviation)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(fieldSearch)))
                        .addGap(18, 18, 18)
                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldAbbreviation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        uomController.UpdateTable(tableUom);
        uomController.clear(fieldId, fieldSearch, fieldName, fieldAbbreviation, areaDescription);
        uomController.setId(fieldId, tableUom);
        fieldName.requestFocus();
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void tableUomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableUomKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP )
        {
         try{
             uomController.setClick(tableUom, fieldSearch, fieldId, fieldName, fieldAbbreviation, areaDescription);
            
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }   
        }
    }//GEN-LAST:event_tableUomKeyPressed

    private void tableUomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUomMouseClicked
       try{
            uomController.setClick(tableUom, fieldSearch, fieldId, fieldName, fieldAbbreviation, areaDescription);
                       
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tableUomMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       try{
            
           uomController.save(fieldId, fieldName, fieldAbbreviation, areaDescription);
           uomController.UpdateTable(tableUom);
           uomController.clear(fieldId, fieldSearch, fieldName, fieldAbbreviation, areaDescription);
           uomController.setId(fieldId, tableUom); 
           fieldName.requestFocus();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error Saving Data");
        }  
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try{
            uomController.update(fieldId, fieldName, fieldAbbreviation, areaDescription);
            uomController.clear(fieldId, fieldSearch, fieldName, fieldAbbreviation, areaDescription);
            uomController.UpdateTable(tableUom);
            uomController.setId(fieldId, tableUom);
            fieldName.requestFocus();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         int p=JOptionPane.showConfirmDialog(null, "Do you really,want to delete data ?","delete",JOptionPane.YES_NO_OPTION);
       if(p==0)
       {
        uomController.delete(fieldName);
        uomController.UpdateTable(tableUom);
        //uomController.clear(fieldId, fieldSearch, fieldName, fieldAbbreviation, areaDescription);
        uomController.setId(fieldId, tableUom);
        fieldName.requestFocus();
       }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void fieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearchKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            uomController.Search(fieldSearch, fieldId, fieldName, fieldAbbreviation, areaDescription);
        }else if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            uomController.clear(fieldId, fieldSearch, fieldName, fieldAbbreviation, areaDescription);
            uomController.setId(fieldId, tableUom);
        }
    }//GEN-LAST:event_fieldSearchKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        uomController.Search(fieldSearch, fieldId, fieldName, fieldAbbreviation, areaDescription);
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescription;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField fieldAbbreviation;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableUom;
    // End of variables declaration//GEN-END:variables
}