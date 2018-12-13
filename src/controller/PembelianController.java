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
import view.comboProduct;
import view.comboSatuan;
import view.comboSupplier;
 

/**
 *
 * @author Dikki Harryadi
 */
public class PembelianController {
      private final Pembelian receivings = new Pembelian();
      private Koneksi koneksi=new Koneksi();
      private comboProduct comboProduct;
      private comboSupplier comboSupplier;
      
      Connection connection=null;
      PreparedStatement ps;
      ResultSet rset;

//##############################################################################
    public void update(javax.swing.JTextField fieldName,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldTotalPrice,com.toedter.calendar.JDateChooser dateBuy,javax.swing.JTextField fieldSupplier) throws ParseException{
        if(!fieldName.getText().equals("")){
          
            java.sql.Date sqlDate = new java.sql.Date(dateBuy.getDate().getTime()); 
            
            receivings.setName(fieldName.getText());
            receivings.setProduct_id(Integer.parseInt(fieldProduct.getText()));
            receivings.setQuantity(Integer.parseInt(fieldQuantity.getText()));
            receivings.setPriceunit(Integer.parseInt(fieldPrice.getText()));
            receivings.setDate(sqlDate);
            receivings.setSupplier_id(Integer.parseInt(fieldSupplier.getText()));
            receivings.update();
        }else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//##############################################################################
    public void save(javax.swing.JTextField fieldName,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldTotalPrice,com.toedter.calendar.JDateChooser dateBuy,javax.swing.JTextField fieldSupplier) throws ParseException{
        if (!fieldName.getText().equals(""))
        {  
     
            java.sql.Date sqlDate = new java.sql.Date(dateBuy.getDate().getTime());       
            receivings.setName(fieldName.getText());
            receivings.setProduct_id(Integer.parseInt(fieldProduct.getText()));
            receivings.setQuantity(Integer.parseInt(fieldQuantity.getText()));
            receivings.setPriceunit(Integer.parseInt(fieldPrice.getText()));
            receivings.setDate(sqlDate);
            receivings.setSupplier_id(Integer.parseInt(fieldSupplier.getText()));
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
    
//##############################################################################
    public void Search(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,com.toedter.calendar.JDateChooser dateDate,javax.swing.JTextField fieldSupplier){
        if (!fieldSearch.getText().equals("")){
            
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            
            receivings.Search(fieldSearch.getText());
            fieldName.setText(receivings.getName());
            fieldProduct.setText(Integer.toString(receivings.getProduct_id()));
            fieldQuantity.setText(Integer.toString(receivings.getQuantity()));
            fieldPrice.setText(Integer.toString(receivings.getPriceunit()));
            ((JTextField)dateDate.getDateEditor().getUiComponent()).setText(dateFormat.format(receivings.getDate()));
            fieldSupplier.setText(Integer.toString(receivings.getSupplier_id()));

        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//##############################################################################
    public void setClick(javax.swing.JTable tableReceiving,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,com.toedter.calendar.JDateChooser dateDate,javax.swing.JTextField fieldSupplier){
        int row =tableReceiving.getSelectedRow();
        String tableClick=(tableReceiving.getModel().getValueAt(row,1).toString());
        int row7 =tableReceiving.getSelectedRow();
        String tableClick7=(tableReceiving.getModel().getValueAt(row7,6).toString());
           SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            receivings.Search(tableClick);
            
            fieldName.setText(receivings.getName());
            fieldProduct.setText(Integer.toString(receivings.getProduct_id()));
            fieldQuantity.setText(Integer.toString(receivings.getQuantity()));
            fieldPrice.setText(Integer.toString(receivings.getPriceunit()));
            ((JTextField)dateDate.getDateEditor().getUiComponent()).setText(dateFormat.format(receivings.getDate()));
            fieldSupplier.setText(Integer.toString(receivings.getSupplier_id()));            
        
    }
    
//##############################################################################
     public void UpdateTable(javax.swing.JTable tableReceivings){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
            String sqlQuery="select * from tb_pembelian";//select xx.id as no,name,product,quantity,price,date_buy,supplier from (select tb_pembelian.id ,tb_pembelian.name ,quantity,price,date_buy,tb_supplier.name supplier from tb_pembelian join tb_supplier on tb_supplier.id=tb_pembelian.id order by id asc) xx join (select tb_product.id,tb_product.name product from tb_product join tb_pembelian on tb_pembelian.id=tb_product.id order by tb_product.id asc)yy on yy.id=xx.id order by no asc;";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableReceivings.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
     
//##############################################################################
     public void Clear(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldQuantity,javax.swing.JTextField fieldPrice,com.toedter.calendar.JDateChooser dateDate,javax.swing.JTextField fieldSupplier){
            
            fieldName.setText("");
            fieldProduct.setText("");
            fieldQuantity.setText("");
            fieldPrice.setText("");
            dateDate.setDate(null);
            fieldSupplier.setText("");
            fieldSearch.setText("");
    }
     
//##############################################################################
    
 
          public void showProduct(JTextField fieldProduct,JTextField fieldPrice,JTextField fieldQuantity){
          
          comboProduct =new comboProduct(null,true);
          comboProduct.setVisible(true);
           if(!comboProduct.getIdSelected().equalsIgnoreCase("")){
              fieldProduct.setText(comboProduct.getIdSelected());
              fieldPrice.setText(comboProduct.getPrice());
              fieldQuantity.requestFocus();
      }
           
      }
          
//##############################################################################
 
          public void showSupplier(JTextField fieldSupplier){
          
          comboSupplier =new comboSupplier(null,true);
          comboSupplier.setVisible(true);
           if(!comboProduct.getIdSelected().equalsIgnoreCase("")){
              fieldSupplier.setText(comboSupplier.getIdSelected());
               
      }
           
      }
 //##############################################################################
    public void UpdateTableProduct(javax.swing.JTable tableProduct){
          
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
           // String sqlQuery="select tb_product.id as no,barcode,tb_product.name,tb_product.description,tb_product.stock ,tb_product.purchase_price purchaseprice,tb_product.sale_price saleprice,tb_unit_of_measure.abbreviation from tb_product join tb_unit_of_measure on tb_product.id=tb_unit_of_measure.id order by tb_product.id asc;";
           String sqlQuery="select id,name,sale_price  from tb_product"; 
           ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableProduct.setModel(DbUtils.resultSetToTableModel(rset));
        rset.close();
        connection.close();
        ps.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
 //##############################################################################
    
       public void UpdateTableSupplier(javax.swing.JTable tableSupplier){
          
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
           // String sqlQuery="select tb_product.id as no,barcode,tb_product.name,tb_product.description,tb_product.stock ,tb_product.purchase_price purchaseprice,tb_product.sale_price saleprice,tb_unit_of_measure.abbreviation from tb_product join tb_unit_of_measure on tb_product.id=tb_unit_of_measure.id order by tb_product.id asc;";
           String sqlQuery="select id,name from tb_supplier"; 
           ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableSupplier.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
}
