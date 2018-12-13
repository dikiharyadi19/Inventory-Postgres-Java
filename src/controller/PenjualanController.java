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
import view.comboCustomer;
import view.comboProduct;
import view.comboSupplier;

/**
 *
 * @author user
 */
public class PenjualanController {
      private final Penjualan transaction = new Penjualan();
      private Koneksi koneksi=new Koneksi();
      private comboCustomer ComboCustomer;
      private comboProduct ComboProduct;
      Connection connection=null;
      PreparedStatement ps;
      ResultSet rset;

//##############################################################################
    public void update(javax.swing.JTextField fieldCustomer,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,com.toedter.calendar.JDateChooser buyDate){
        if(!fieldCustomer.getText().equals("")){
            
            java.sql.Date date=new java.sql.Date(buyDate.getDate().getTime());
            transaction.setCustomer_id(Integer.parseInt(fieldCustomer.getText()));
            transaction.setProduct_id(Integer.parseInt(fieldProduct.getText()));
            transaction.setPrice(Integer.parseInt(fieldPrice.getText()));
            transaction.setQuantity(Integer.parseInt(fieldQuantity.getText()));
            transaction.setDate_sell(date);
            transaction.update();
        }else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################      
    public void save(javax.swing.JTextField fieldCustomer,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,JDateChooser buyDate){
        if (!fieldProduct.getText().equals(""))
        {  
          
            java.sql.Date date=new java.sql.Date(buyDate.getDate().getTime());
            
            transaction.setCustomer_id(Integer.parseInt(fieldCustomer.getText()));  
            transaction.setProduct_id(Integer.parseInt(fieldProduct.getText()));
            transaction.setPrice(Integer.parseInt(fieldPrice.getText()));
            transaction.setQuantity(Integer.parseInt(fieldQuantity.getText()));
            transaction.setDate_sell(date);
            transaction.save();
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################    
    public void delete(javax.swing.JTextField fieldProduct){
        if (!fieldProduct.equals("")){
            transaction.delete(Integer.parseInt(fieldProduct.getText()));
            
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################    
    public void Search(javax.swing.JTextField  fieldSearch,javax.swing.JTextField fieldCustomer,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,com.toedter.calendar.JDateChooser buyDate){
        if (!fieldSearch.getText().equals("")){
            
            transaction.Search(Integer.parseInt(fieldSearch.getText()));
            fieldCustomer.setText(Integer.toString(transaction.getCustomer_id()));
            fieldProduct.setText(Integer.toString(transaction.getProduct_id()));
            fieldPrice.setText(Integer.toString(transaction.getQuantity()));
            fieldQuantity.setText(Integer.toString(transaction.getQuantity()));
            ((JTextField)buyDate.getDateEditor().getUiComponent()).setText(transaction.getDate_sell().toString());
            
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################
    public void setClick(javax.swing.JTextField fieldName,javax.swing.JTable tableTransaction,javax.swing.JTextField fieldCustomer,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,com.toedter.calendar.JDateChooser buyDate){
        int row =tableTransaction.getSelectedRow();
        String tableClick=(tableTransaction.getModel().getValueAt(row,0).toString());
         
            transaction.Search(Integer.parseInt(tableClick));
            fieldCustomer.setText(Integer.toString(transaction.getCustomer_id()));
            fieldName.setText(transaction.getName());
            fieldProduct.setText(Integer.toString(transaction.getProduct_id()));
            fieldPrice.setText(Integer.toString(transaction.getPrice()));
            fieldQuantity.setText(Integer.toString(transaction.getQuantity()));
            ((JTextField)buyDate.getDateEditor().getUiComponent()).setText(transaction.getDate_sell().toString()); 
    }
//##############################################################################
    public void UpdateTable(javax.swing.JTable tableTransaction){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
            String sqlQuery="select * from tb_penjualan;";//"select xx.id,customer, name,product,price,quantity,date_sell from (select tb_penjualan.id ,tb_customer.name customer,tb_penjualan.name ,price,quantity,date_sell from tb_penjualan join tb_customer on tb_customer.id=tb_penjualan.id order by id asc) xx join (select tb_product.id,tb_product.name product from tb_product join tb_penjualan on tb_penjualan.id=tb_product.id order by tb_product.id asc)yy on yy.id=xx.id order by id asc;";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableTransaction.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
    
//##############################################################################
     public void Clear(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldCustomer,javax.swing.JTextField fieldProduct,javax.swing.JTextField fieldPrice,javax.swing.JTextField fieldQuantity,com.toedter.calendar.JDateChooser buyDate){
            
            fieldSearch.setText("");
            fieldCustomer.setText("");
            fieldProduct.setText("");
            fieldPrice.setText("");
            fieldQuantity.setText("");
            buyDate.setDate(null);
    }
//##############################################################################
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
//##############################################################################
      public void setComboProduct(javax.swing.JTextField fieldName,javax.swing.JComboBox comboProduct){
          if(comboProduct.isEditable()){
             String name=comboProduct.getSelectedItem().toString();
             fieldName.setText(name);
          }else{
            
          }
      }
      //##############################################################################
 
          public void showProduct(JTextField fieldProduct,JTextField fieldPrice){
          
          ComboProduct =new comboProduct(null,true);
          ComboProduct.setVisible(true);
           if(!ComboProduct.getIdSelected().equals("")){
              fieldProduct.setText(ComboProduct.getIdSelected());
              fieldPrice.setText(ComboProduct.getPrice());
      }
           
      }
          
//##############################################################################
 
          public void showCustomer(JTextField fieldCustomer){
          
          ComboCustomer =new comboCustomer(null,true);
          ComboCustomer.setVisible(true);
           if(!ComboCustomer.getIdSelected().equals("")){
              fieldCustomer.setText(ComboCustomer.getIdSelected());
               
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
            String sqlQuery="select id,name  from tb_product"; 
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
    
       public void UpdateTableCustomer(javax.swing.JTable tableCustomer){
          
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
           // String sqlQuery="select tb_product.id as no,barcode,tb_product.name,tb_product.description,tb_product.stock ,tb_product.purchase_price purchaseprice,tb_product.sale_price saleprice,tb_unit_of_measure.abbreviation from tb_product join tb_unit_of_measure on tb_product.id=tb_unit_of_measure.id order by tb_product.id asc;";
            String sqlQuery="select id,name from tb_customer"; 
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableCustomer.setModel(DbUtils.resultSetToTableModel(rset));
            
            rset.close();
            connection.close();
            ps.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
    }
      
}
