/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Customers;
import model.Koneksi;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author Dikki Harryadi
 */

public class CustomerController {
    private final Customers customer = new Customers();
    private Koneksi koneksi=new Koneksi();
  public void toExcel(JTable tableCustomer, File file){
    try{
        TableModel model = tableCustomer.getModel();
        FileWriter excel = new FileWriter(file);

        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + "\t");
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i,j).toString()+"\t");
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
}
        int id=0;
public void setId(javax.swing.JTextField fieldId,javax.swing.JTable tableCustomer){
     int row=tableCustomer.getRowCount();
    // int cell=(int) tableCustomer.getModel().getValueAt(3, 0);
    // String tableClick=(tableCustomer.getModel().getValueAt(row,0).toString());
     //int cell=Integer.parseInt(tableClick);
      if(tableCustomer.getRowCount()==0){
          for(int x=0;x<1; x++){
              id=1;
               fieldId.setText(Integer.toString(id));
          }
      }/*else if( cell==row ){
           for(int x=0;x<1; x++){
               id=tableCustomer.getRowCount();
              id++;
               fieldId.setText(Integer.toString(id));
          }
      }*/
      else {
           for(int x=0;x<1; x++){
               id=tableCustomer.getRowCount();
              id++;
               fieldId.setText(Integer.toString(id));
          }
      }
      //int row =tableCustomer.getSelectedRow();
       //String tableClick=(tableCustomer.getModel().getValueAt(row, id).toString());
            
     // if(tableCustomer){
          
      //}
          
        
  }
  public void update(javax.swing.JTextField fieldId,javax.swing.JTextField fieldNameCustomer, javax.swing.JTextField fieldEmailCustomer, javax.swing.JTextField fieldPhoneCustomer, javax.swing.JTextArea areaAddressCustomer){
        if (!fieldNameCustomer.getText().equals(""))
        {
            customer.setId(Integer.parseInt(fieldId.getText()));
            customer.setName(fieldNameCustomer.getText());
            customer.setEmail(fieldEmailCustomer.getText());
            customer.setPhone(fieldPhoneCustomer.getText());
            customer.setAddress(areaAddressCustomer.getText());
            customer.update();
            
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public void save(javax.swing.JTextField fieldId,javax.swing.JTextField NameCustomer, javax.swing.JTextField EmailCustomer, javax.swing.JTextField PhoneCustomer, javax.swing.JTextArea AddressCustomer){
        if (!NameCustomer.getText().equals(""))
        {
            customer.setId(Integer.parseInt(fieldId.getText()));
            customer.setName(NameCustomer.getText());
            customer.setEmail(EmailCustomer.getText());
            customer.setPhone(PhoneCustomer.getText());
            customer.setAddress(AddressCustomer.getText());
            customer.save();
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(javax.swing.JTextField fieldNameCustomer){
        if (!fieldNameCustomer.getText().equals("")){
            customer.delete(fieldNameCustomer.getText());
        } else {
            JOptionPane.showMessageDialog(null, "NIM tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Search(javax.swing.JTextField fieldId,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldNameCustomer,javax.swing.JTextField fieldEmailCustomer,javax.swing.JTextField fieldPhoneCustomer,javax.swing.JTextArea areaAddressCustomer){
       if(!fieldSearch.getText().equals("")){
       customer.Search(fieldSearch.getText());
       fieldId.setText(Integer.toString((customer.getId())));
       fieldNameCustomer.setText(customer.getName());
       fieldEmailCustomer.setText(customer.getEmail());
       fieldPhoneCustomer.setText(customer.getPhone());
       areaAddressCustomer.setText(customer.getAddress());
       } 
    }
    public void setClick(javax.swing.JTextField fieldId,javax.swing.JTable tableCustomer,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldNameCustomer,javax.swing.JTextField fieldEmailCustomer,javax.swing.JTextField fieldPhoneCustomer,javax.swing.JTextArea areaAddressCustomer){
       int row =tableCustomer.getSelectedRow();
       String tableClick=(tableCustomer.getModel().getValueAt(row,1).toString());
            
       customer.Search(tableClick);
       fieldId.setText(Integer.toString((customer.getId())));
       fieldNameCustomer.setText(customer.getName());
       fieldEmailCustomer.setText(customer.getEmail());
       fieldPhoneCustomer.setText(customer.getPhone());
       areaAddressCustomer.setText(customer.getAddress());
    }
   
    
     public void UpdateTable(javax.swing.JTable tableCustomer){
     
         Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
            String sqlQuery="select id as no,name ,email ,phone,address from tb_customer order by id asc";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableCustomer.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
     }
     
     public void clear(javax.swing.JTextField fieldId,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldNameCustomer,javax.swing.JTextField fieldEmailCustomer ,javax.swing.JTextField fieldPhoneCustomer,javax.swing.JTextArea areaAddressCustomer){
         fieldSearch.setText("");
         fieldId.setText("");
         fieldNameCustomer.setText("");
         fieldEmailCustomer.setText("");
         fieldPhoneCustomer.setText("");
         areaAddressCustomer.setText("");
     }
     
}

