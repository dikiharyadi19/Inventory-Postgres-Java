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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Koneksi;
import model.Pembelian;
import net.proteanit.sql.DbUtils;
 

/**
 *
 * @author Dikki Harryadi
 */
public class PembelianController {
      private final Pembelian receivings = new Pembelian();
      private Koneksi koneksi=new Koneksi();
     
      Connection connection=null;
      PreparedStatement ps;
      ResultSet rset;
      int id=0;
    public void setId(javax.swing.JTextField fieldId,javax.swing.JTable tableReceiving){
        if(tableReceiving.getRowCount()==0){
            for(int x=0;x<1;x++){
                id=1;
                fieldId.setText(Integer.toString(id));
            }
        }else{
            for(int x=0;x<1; x++){
               id=tableReceiving.getRowCount();
               id++;
               fieldId.setText(Integer.toString(id));
        }
    }
    }
    public void update(javax.swing.JTextField fieldId,javax.swing.JTextField fieldName,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldTotalPrice,com.toedter.calendar.JDateChooser dateBuy,javax.swing.JComboBox comboSupplier) throws ParseException{
        if(!fieldName.getText().equals("")){
            // String -> Date
  
            
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            
            Date date=dateBuy.getDate();//dateFormat.format(dateBuy.getDate());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
             
             
            receivings.setId(Integer.parseInt(fieldId.getText()));
            receivings.setName(fieldName.getText());
            receivings.setProduct_id(comboProduct.getSelectedIndex());
            receivings.setQuantity(Integer.parseInt(fieldQuantity.getText()));
            receivings.setPriceunit(Integer.parseInt(fieldPrice.getText()));
         //   receivings.setTotalprice(Integer.parseInt(fieldTotalPrice.getText()));
            
         
            receivings.setDate(sqlDate);//dateFormat.format(dateBuy.getDate()));
            receivings.setSupplier_id(comboSupplier.getSelectedIndex());
            receivings.update();
        }else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
      
    public void save(javax.swing.JTextField fieldId,javax.swing.JTextField fieldName,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldTotalPrice,com.toedter.calendar.JDateChooser dateBuy,javax.swing.JComboBox comboSupplier) throws ParseException{
        if (!fieldName.getText().equals(""))
        {  
             Date date=dateBuy.getDate();//dateFormat.format(dateBuy.getDate());
            java.sql.Date sqlDate = new java.sql.Date(date.getDate());
            System.out.println(sqlDate);
            
            receivings.setId(Integer.parseInt(fieldId.getText()));
            receivings.setName(fieldName.getText());
            receivings.setProduct_id(comboProduct.getSelectedIndex());
            receivings.setQuantity(Integer.parseInt(fieldQuantity.getText()));
          
            receivings.setPriceunit(Integer.parseInt(fieldPrice.getText()));
           // receivings.setTotalprice(Integer.parseInt(fieldTotalPrice.getText()));
            receivings.setDate(sqlDate);//dateFormat.format(dateBuy.getDate()));
            receivings.setSupplier_id(comboSupplier.getSelectedIndex());
            receivings.save();
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(javax.swing.JTextField fieldName){
        if (!fieldName.getText().equals("")){
            receivings.delete(fieldName.getText());
            
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Search(javax.swing.JTextField fieldId,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,com.toedter.calendar.JDateChooser dateDate,javax.swing.JComboBox comboSupplier){
        if (!fieldSearch.getText().equals("")){
            
             SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            receivings.Search(fieldSearch.getText());
            fieldId.setText(Integer.toString(receivings.getId()));
            fieldName.setText(receivings.getName());
            comboProduct.setSelectedIndex(receivings.getProduct_id());
            fieldQuantity.setText(Integer.toString(receivings.getQuantity()));
            fieldPrice.setText(Integer.toString(receivings.getPriceunit()));
           // fieldTotalPrice.setText(Integer.toString(receivings.getTotalprice()));
            ((JTextField)dateDate.getDateEditor().getUiComponent()).setText(dateFormat.format(receivings.getDate()));
            comboSupplier.setSelectedIndex(receivings.getSupplier_id());
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void setClick(javax.swing.JTextField fieldId,javax.swing.JTable tableReceiving,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,com.toedter.calendar.JDateChooser dateDate,javax.swing.JComboBox comboSupplier){
        int row =tableReceiving.getSelectedRow();
        String tableClick=(tableReceiving.getModel().getValueAt(row,1).toString());
        int row7 =tableReceiving.getSelectedRow();
        String tableClick7=(tableReceiving.getModel().getValueAt(row7,6).toString());
           SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            receivings.Search(tableClick);
            
            fieldId.setText(Integer.toString(receivings.getId()));
            fieldName.setText(receivings.getName());
            comboProduct.setSelectedIndex(receivings.getProduct_id());
            fieldQuantity.setText(Integer.toString(receivings.getQuantity()));
            fieldPrice.setText(Integer.toString(receivings.getPriceunit()));
          //  fieldTotalPrice.setText(Integer.toString(receivings.getTotalprice()));
            ((JTextField)dateDate.getDateEditor().getUiComponent()).setText(dateFormat.format(receivings.getDate()));
            comboSupplier.setSelectedIndex(receivings.getSupplier_id());            
        
    }
     public void UpdateTable(javax.swing.JTable tableReceivings){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
            String sqlQuery="select xx.id as no,name,product,quantity,price,date_buy,supplier from (select tb_pembelian.id ,tb_pembelian.name ,quantity,price,date_buy,tb_supplier.name supplier from tb_pembelian join tb_supplier on tb_supplier.id=tb_pembelian.id order by id asc) xx join (select tb_product.id,tb_product.name product from tb_product join tb_pembelian on tb_pembelian.id=tb_product.id order by tb_product.id asc)yy on yy.id=xx.id order by no asc;";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableReceivings.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
     public void Clear(javax.swing.JTextField fieldId,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,javax.swing.JComboBox comboProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,com.toedter.calendar.JDateChooser dateDate,javax.swing.JComboBox comboSupplier){
            fieldId.setText("");
            fieldName.setText("");
            comboProduct.setSelectedIndex(0);
            fieldQuantity.setText("");
            fieldPrice.setText("");
           // fieldTotalPrice.setText("");
            dateDate.setDate(null);
            comboSupplier.setSelectedIndex(0);            

            fieldSearch.setText("");
    }
      public void setCombo(javax.swing.JComboBox comboSupplier){
        try{
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        String querySql="select * from tb_supplier order by id asc";
        ps=connection.prepareStatement(querySql);
        rset=ps.executeQuery();
        
        while(rset.next()){
            String name=rset.getString("name");
            comboSupplier.addItem(name);
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
}
