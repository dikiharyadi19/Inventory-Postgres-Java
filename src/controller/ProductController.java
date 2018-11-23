/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Koneksi;

import model.Products;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Dikki Harryadi
 */
public class ProductController {
    private final Products product = new Products();
    private Koneksi koneksi=new Koneksi();
    
    Connection connection=null;
    PreparedStatement ps;
    ResultSet rser;
    int id=0;
    
    public void setId(javax.swing.JTextField fieldId,javax.swing.JTable tableProduct){
        if(tableProduct.getRowCount()==0){
            for(int x=0;x<1;x++){
                id=1;
                fieldId.setText(Integer.toString(id));
            }
        }else{
            for(int x=0;x<1; x++){
               id=tableProduct.getRowCount();
               id++;
               fieldId.setText(Integer.toString(id));
        }
    }
    }
    
    public void update(javax.swing.JTextField fieldBarcode,javax.swing.JTextField fieldId,javax.swing.JTextField fieldName,javax.swing.JTextArea areaDescription,javax.swing.JComboBox comboUom,javax.swing.JTextField fieldStock,javax.swing.JTextField fieldPurchasePrice,javax.swing.JTextField fieldSalePrice){
        if(!fieldBarcode.getText().equals("")){
            product.setId(Integer.parseInt(fieldId.getText()));
            product.setBarcode(Integer.parseInt(fieldBarcode.getText()));
            product.setName(fieldName.getText());
            product.setDescription(areaDescription.getText());
            product.setUnit_of_measure_id(comboUom.getSelectedIndex());
            product.setStock(Integer.parseInt(fieldStock.getText()));
            product.setPurchase_price(Integer.parseInt(fieldPurchasePrice.getText()));
            product.setSale_price(Integer.parseInt(fieldSalePrice.getText()));
            product.update();
        }else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void save(javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldBarcode, javax.swing.JTextArea areaDescription,javax.swing.JComboBox comboUom,javax.swing.JTextField fieldStock ,javax.swing.JTextField fieldPurchasePrice,javax.swing.JTextField fieldSalePrice){
            
        if (!fieldBarcode.getText().equals(""))
        {
            product.setId(Integer.parseInt(fieldId.getText()));
            product.setBarcode(Integer.parseInt(fieldBarcode.getText()));
            product.setName(fieldName.getText());
            product.setDescription(areaDescription.getText());
            product.setUnit_of_measure_id(comboUom.getSelectedIndex());
            product.setStock(Integer.parseInt(fieldStock.getText()));
            product.setPurchase_price(Integer.parseInt(fieldPurchasePrice.getText()));
            product.setSale_price(Integer.parseInt(fieldSalePrice.getText()));
            product.save();
            
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(javax.swing.JTextField fieldBarcode){
        if (!fieldBarcode.getText().equals("")){
            product.delete(Integer.parseInt(fieldBarcode.getText()));
            
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Search(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldBarcode, javax.swing.JTextArea areaDescription,javax.swing.JComboBox comboUom,javax.swing.JTextField fieldStock ,javax.swing.JTextField fieldPurchasePrice,javax.swing.JTextField fieldSalePrice){
        if (!fieldSearch.getText().equals("")){
            product.Search(Integer.parseInt(fieldSearch.getText()));
            fieldId.setText(Integer.toString((product.getId())));
            fieldBarcode.setText(Integer.toString(product.getBarcode()));
            fieldName.setText(product.getName());
            areaDescription.setText(product.getDescription());
            comboUom.setSelectedIndex(product.getUnit_of_measure_id());
            fieldStock.setText(Integer.toString(product.getStock()));
            fieldPurchasePrice.setText(Integer.toString(product.getPurchase_price()));
            fieldSalePrice.setText(Integer.toString(product.getSale_price()));            
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
   public void setClick(javax.swing.JTable tableProduct,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldBarcode, javax.swing.JTextArea areaDescription,javax.swing.JComboBox comboUom,javax.swing.JTextField fieldStock ,javax.swing.JTextField fieldPurchasePrice,javax.swing.JTextField fieldSalePrice){
        int row =tableProduct.getSelectedRow();
        String tableClick=(tableProduct.getModel().getValueAt(row,1).toString());
          
            product.Search(Integer.parseInt(tableClick));
            fieldId.setText(Integer.toString((product.getId())));
            fieldBarcode.setText(Integer.toString(product.getBarcode()));
            fieldName.setText(product.getName());
            areaDescription.setText(product.getDescription());
            comboUom.setSelectedIndex(product.getUnit_of_measure_id());
            fieldStock.setText(Integer.toString(product.getStock()));
            fieldPurchasePrice.setText(Integer.toString(product.getPurchase_price()));
            fieldSalePrice.setText(Integer.toString(product.getSale_price()));            
        
    }
    
    public void UpdateTable(javax.swing.JTable tableProduct){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
           // String sqlQuery="select tb_product.id as no,barcode,tb_product.name,tb_product.description,tb_product.stock ,tb_product.purchase_price purchaseprice,tb_product.sale_price saleprice,tb_unit_of_measure.abbreviation from tb_product join tb_unit_of_measure on tb_product.id=tb_unit_of_measure.id order by tb_product.id asc;";
           String sqlQuery="select * from tb_product"; 
           ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableProduct.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
      public void Clear(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldBarcode, javax.swing.JTextArea areaDescription,javax.swing.JComboBox comboUom,javax.swing.JTextField fieldStock ,javax.swing.JTextField fieldPurchasePrice,javax.swing.JTextField fieldSalePrice){
            fieldId.setText("");
            fieldBarcode.setText("");
            fieldName.setText("");
            areaDescription.setText("");
            comboUom.setSelectedIndex(0);
            fieldStock.setText("");
            fieldPurchasePrice.setText("");
            fieldSalePrice.setText("");
            fieldSearch.setText("");
    }
     public void setCombo(javax.swing.JComboBox comboUom){
        try{
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        String querySql="select * from tb_unit_of_measure order by id asc";
        ps=connection.prepareStatement(querySql);
        rset=ps.executeQuery();
        
        while(rset.next()){
            String name=rset.getString("abbreviation");
            comboUom.addItem(name);
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
    }
    
    
}
