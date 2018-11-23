/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Koneksi;
import model.Penjualan;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class PenjualanController {
     private final Penjualan transaction = new Penjualan();
      private Koneksi koneksi=new Koneksi();
     
      Connection connection=null;
      PreparedStatement ps;
      ResultSet rset;
      int id=0;
    public void setId(javax.swing.JTextField fieldId,javax.swing.JTable tableTransaction){
        if(tableTransaction.getRowCount()==0){
            for(int x=0;x<1;x++){
                id=1;
                fieldId.setText(Integer.toString(id));
            }
        }else{
            for(int x=0;x<1; x++){
               id=tableTransaction.getRowCount();
               id++;
               fieldId.setText(Integer.toString(id));
        }
    }
    }
    public void update(javax.swing.JTextField fieldName,javax.swing.JCheckBox boxMember,javax.swing.JTextField fieldId,javax.swing.JComboBox comboCustomer,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,com.toedter.calendar.JDateChooser buyDate){
        if(!comboCustomer.getSelectedItem().equals("==Select==")){
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            String date=dateFormat.format(buyDate.getDate());
            transaction.setId(Integer.parseInt(fieldId.getText()));
            if(boxMember.isSelected()){
                transaction.setCustomer_id(comboCustomer.getSelectedIndex());
            }else{
                 transaction.setName(fieldName.getText());
            }
            transaction.setProduct_id(comboProduct.getSelectedIndex());
            transaction.setPrice(Integer.parseInt(fieldPrice.getText()));
            transaction.setQuantity(Integer.parseInt(fieldQuantity.getText()));
            transaction.setDate_sell(date);
            transaction.update();
        }else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
      
    public void save(javax.swing.JCheckBox boxMember,javax.swing.JTextField fieldName,javax.swing.JTextField fieldId,javax.swing.JComboBox comboCustomer,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,JDateChooser buyDate){
        if (!comboProduct.getSelectedItem().equals("==Select=="))
        {  
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            String date=dateFormat.format(buyDate.getDate());
            transaction.setId(Integer.parseInt(fieldId.getText()));
            if(boxMember.isSelected()){
                transaction.setCustomer_id(comboCustomer.getSelectedIndex());
            }else{
                transaction.setName(fieldName.getText());
            }
            transaction.setProduct_id(comboProduct.getSelectedIndex());
            transaction.setPrice(Integer.parseInt(fieldPrice.getText()));
            transaction.setQuantity(Integer.parseInt(fieldQuantity.getText()));
            transaction.setDate_sell(date);
            transaction.save();
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(javax.swing.JTextField fieldId,javax.swing.JComboBox comboProduct){
        if (!comboProduct.getSelectedItem().equals("==Select==")){
            transaction.delete(Integer.parseInt(fieldId.getText()));
            
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Search(javax.swing.JTextField fieldName,javax.swing.JCheckBox boxMember,javax.swing.JTextField  fieldSearch,javax.swing.JTextField fieldId,javax.swing.JComboBox comboCustomer,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,com.toedter.calendar.JDateChooser buyDate){
        if (!fieldSearch.getText().equals("")){
            
            transaction.Search(Integer.parseInt(fieldSearch.getText()));
            fieldId.setText(Integer.toString(transaction.getId()));
             if(boxMember.isSelected()){
                comboCustomer.setSelectedIndex(transaction.getCustomer_id());
            }else{
                fieldName.setText(transaction.getName());
            }
            
            comboProduct.setSelectedIndex(transaction.getProduct_id());
            fieldPrice.setText(Integer.toString(transaction.getQuantity()));
            fieldQuantity.setText(Integer.toString(transaction.getQuantity()));
            ((JTextField)buyDate.getDateEditor().getUiComponent()).setText(transaction.getDate_sell());
            
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void setClick(javax.swing.JTextField fieldName,javax.swing.JCheckBox boxMember,javax.swing.JTable tableTransaction,javax.swing.JTextField fieldId,javax.swing.JComboBox comboCustomer,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,com.toedter.calendar.JDateChooser buyDate){
        int row =tableTransaction.getSelectedRow();
        String tableClick=(tableTransaction.getModel().getValueAt(row,0).toString());
         
            transaction.Search(Integer.parseInt(tableClick));
            
            fieldId.setText(Integer.toString(transaction.getId()));
            if(boxMember.isSelected()){
                comboCustomer.setSelectedIndex(transaction.getCustomer_id());
            }else{
                fieldName.setText(transaction.getName());
            }
            comboProduct.setSelectedIndex(transaction.getProduct_id());
            fieldPrice.setText(Integer.toString(transaction.getPrice()));
            fieldQuantity.setText(Integer.toString(transaction.getQuantity()));
            ((JTextField)buyDate.getDateEditor().getUiComponent()).setText(transaction.getDate_sell()); 
    }
     public void UpdateTable(javax.swing.JTable tableTransaction){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
            String sqlQuery="select xx.id,customer, name,product,price,quantity,date_sell from (select tb_penjualan.id ,tb_customer.name customer,tb_penjualan.name ,price,quantity,date_sell from tb_penjualan join tb_customer on tb_customer.id=tb_penjualan.id order by id asc) xx join (select tb_product.id,tb_product.name product from tb_product join tb_penjualan on tb_penjualan.id=tb_product.id order by tb_product.id asc)yy on yy.id=xx.id order by id asc;";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableTransaction.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
     public void Clear(javax.swing.JTextField fieldName,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldId,javax.swing.JComboBox comboCustomer,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,com.toedter.calendar.JDateChooser buyDate){
            fieldId.setText("");
            fieldSearch.setText("");
            comboCustomer.setSelectedIndex(0);
            fieldName.setText("");
            comboProduct.setSelectedIndex(0);
            fieldPrice.setText("");
            fieldQuantity.setText("");
            buyDate.setDate(null);
    }
      public void setCombo(javax.swing.JComboBox comboCustomer){
        try{
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        String querySql="select * from tb_customer order by id asc";
        ps=connection.prepareStatement(querySql);
        rset=ps.executeQuery();
        
        while(rset.next()){
            String name=rset.getString("name");
            comboCustomer.addItem(name);
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
      }
      public void setCombo2(javax.swing.JComboBox comboProduct){
        try{
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        String querySql="select * from tb_product order by id asc";
        ps=connection.prepareStatement(querySql);
        rset=ps.executeQuery();
        
        while(rset.next()){
            String name=rset.getString("name");
            comboProduct.addItem(name);
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
      }
      public void setPrice(String comboProduct ,javax.swing.JTextField fieldPrice){
        try{
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        String querySql="select * from tb_product where name=?";
        ps=connection.prepareStatement(querySql);
        ps.setString(1, comboProduct);
        rset=ps.executeQuery();
        
        while(rset.next()){
            int price=rset.getInt("sale_price");
            fieldPrice.setText(Integer.toString(price));
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
      }
      public void setComboProduct(javax.swing.JTextField fieldName,javax.swing.JComboBox comboProduct){
          if(comboProduct.isEditable()){
             String name=comboProduct.getSelectedItem().toString();
             fieldName.setText(name);
          }else{
            
          }
      }
}
