/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PembelianController;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


/**
 *
 * @author Dikki Haryadi
 */
public class TabPembelian extends javax.swing.JPanel {
    private final PembelianController receivingController=new PembelianController();
     
    /**
     * Creates new form TabReceiving
     */
    public TabPembelian() {
        initComponents();
        receivingController.UpdateTable(tableReceiving);
     
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableReceiving = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnFaktur = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        fieldQuantity = new javax.swing.JTextField();
        fieldPrice = new javax.swing.JTextField();
        fieldName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateBuy = new com.toedter.calendar.JDateChooser();
        fieldSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        fieldProduct = new javax.swing.JTextField();
        btnLihatProduct = new javax.swing.JButton();
        fieldSupplier = new javax.swing.JTextField();
        btnLihatSupplier = new javax.swing.JButton();

        setBackground(new java.awt.Color(187, 187, 187));

        tableReceiving.setBackground(new java.awt.Color(187, 187, 187));
        tableReceiving.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name Employee", "Prouct", "Quantity", "Price Unit", "Total Price", "Supplier"
            }
        ));
        tableReceiving.setSelectionBackground(new java.awt.Color(249, 84, 55));
        tableReceiving.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableReceiving.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReceivingMouseClicked(evt);
            }
        });
        tableReceiving.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableReceivingKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableReceiving);

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

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnFaktur.setText("Faktur");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFaktur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnFaktur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(187, 187, 187));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Supplier*");

        fieldPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldPriceKeyReleased(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nama Karyawan");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Quantity");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nama Barang*");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tanggal Penerimaan*");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Harga Satuan");

        dateBuy.setDateFormatString("dd-MM-yyyy");

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

        fieldProduct.setEnabled(false);

        btnLihatProduct.setText("Lihat");
        btnLihatProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatProductActionPerformed(evt);
            }
        });

        fieldSupplier.setEnabled(false);

        btnLihatSupplier.setText("Lihat");
        btnLihatSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldPrice)
                            .addComponent(fieldQuantity)
                            .addComponent(dateBuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fieldSupplier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLihatSupplier))
                            .addComponent(jLabel12)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch))
                    .addComponent(fieldName)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fieldProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLihatProduct))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(0, 257, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(fieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLihatProduct)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(fieldProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLihatSupplier))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            
            receivingController.save(fieldName, fieldProduct, fieldQuantity, fieldPrice, fieldPrice, dateBuy, fieldSupplier);
            receivingController.UpdateTable(tableReceiving);
            receivingController.Clear(fieldSearch, fieldName, fieldProduct, fieldQuantity, fieldPrice,  dateBuy, fieldSupplier);
            fieldName.requestFocus();
            
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Saving Data");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        receivingController.UpdateTable(tableReceiving);
        receivingController.Clear(fieldSearch, fieldName, fieldProduct, fieldQuantity, fieldPrice, dateBuy, fieldSupplier);
        
        fieldName.requestFocus();
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try{
            receivingController.update( fieldName, fieldProduct, fieldQuantity, fieldPrice, fieldPrice, dateBuy, fieldSupplier);
            receivingController.Clear(fieldSearch, fieldName, fieldProduct, fieldQuantity, fieldPrice, dateBuy, fieldSupplier);
            receivingController.UpdateTable(tableReceiving);
            fieldName.requestFocus();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }
       

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int p=JOptionPane.showConfirmDialog(null, "Do you really,want to delete data ?","delete",JOptionPane.YES_NO_OPTION);
       if(p==0)
       {
           
        receivingController.delete(fieldName);
        receivingController.UpdateTable(tableReceiving);
        fieldName.requestFocus();
        
       }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableReceivingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReceivingMouseClicked
        try{
           receivingController.setClick( tableReceiving, fieldSearch, fieldName, fieldProduct, fieldQuantity, fieldPrice,dateBuy, fieldSupplier);
        
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tableReceivingMouseClicked

    private void tableReceivingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableReceivingKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP )
        {
            receivingController.setClick( tableReceiving, fieldSearch, fieldName, fieldProduct, fieldQuantity, fieldPrice,  dateBuy, fieldSupplier);
        }
    }//GEN-LAST:event_tableReceivingKeyPressed

    private void fieldPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldPriceKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        int quantity,price,totalPrice;
        quantity=Integer.parseInt(fieldQuantity.getText());
        price=Integer.parseInt(fieldPrice.getText());
        totalPrice=quantity*price;
       
        }
    }//GEN-LAST:event_fieldPriceKeyReleased

    private void fieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearchKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            receivingController.Search(fieldSearch, fieldName, fieldProduct, fieldQuantity, fieldPrice,  dateBuy,fieldSupplier);
        }else if(evt.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            receivingController.Clear(fieldSearch, fieldName, fieldProduct, fieldQuantity, fieldPrice,dateBuy, fieldSupplier);
        }
    }//GEN-LAST:event_fieldSearchKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        receivingController.Search( fieldSearch, fieldName, fieldProduct, fieldQuantity, fieldPrice,dateBuy, fieldSupplier);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLihatProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatProductActionPerformed
        // TODO add your handling code here:
        receivingController.showProduct(fieldProduct,fieldPrice,fieldQuantity);
    }//GEN-LAST:event_btnLihatProductActionPerformed

    private void btnLihatSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatSupplierActionPerformed
        // TODO add your handling code here:
        receivingController.showSupplier(fieldSupplier);
    }//GEN-LAST:event_btnLihatSupplierActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFaktur;
    private javax.swing.JButton btnLihatProduct;
    private javax.swing.JButton btnLihatSupplier;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dateBuy;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldPrice;
    private javax.swing.JTextField fieldProduct;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JTextField fieldSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableReceiving;
    // End of variables declaration//GEN-END:variables
}
