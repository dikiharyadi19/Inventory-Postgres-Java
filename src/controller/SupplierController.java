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
import model.Suppliers;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author Dikki Harryadi
 */

public class SupplierController {
    private final Suppliers suppliers = new Suppliers();
    private Koneksi koneksi=new Koneksi();
  
        int id=0;
public void setId(javax.swing.JTextField fieldId,javax.swing.JTable tableSupplier){
     
      if(tableSupplier.getRowCount()==0){
          for(int x=0;x<1; x++){
              id=1;
               fieldId.setText(Integer.toString(id));
          }
      }else {
           for(int x=0;x<1; x++){
               id=tableSupplier.getRowCount();
              id++;
               fieldId.setText(Integer.toString(id));
          }
      }
      //int row =tableCustomer.getSelectedRow();
       //String tableClick=(tableCustomer.getModel().getValueAt(row, id).toString());
            
     // if(tableCustomer){
          
      //}
          
        
  }
  public void update(javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldCompanyName, javax.swing.JTextField fieldEmail, javax.swing.JTextField fieldPhone,javax.swing.JTextArea areaDescription){
        if (!fieldName.getText().equals(""))
        {
            suppliers.setId(Integer.parseInt(fieldId.getText()));
            suppliers.setName(fieldName.getText());
            suppliers.setCompanyName(fieldCompanyName.getText());
            suppliers.setEmail(fieldEmail.getText());
            suppliers.setPhone(fieldPhone.getText());
            suppliers.setDescription(areaDescription.getText());
            suppliers.update();
            
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public void save(javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldCompanyName, javax.swing.JTextField fieldEmail, javax.swing.JTextField fieldPhone,javax.swing.JTextArea areaDescription){
        if (!fieldName.getText().equals(""))
        {
           suppliers.setId(Integer.parseInt(fieldId.getText()));
            suppliers.setName(fieldName.getText());
            suppliers.setCompanyName(fieldCompanyName.getText());
            suppliers.setEmail(fieldEmail.getText());
            suppliers.setPhone(fieldPhone.getText());
            suppliers.setDescription(areaDescription.getText());
            suppliers.save();
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(javax.swing.JTextField fieldName){
        if (!fieldName.getText().equals("")){
            suppliers.delete(fieldName.getText());
        } else {
            JOptionPane.showMessageDialog(null, "NIM tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Search(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldCompanyName, javax.swing.JTextField fieldEmail, javax.swing.JTextField fieldPhone,javax.swing.JTextArea areaDescription){
       if(!fieldSearch.getText().equals("")){
       suppliers.Search(fieldSearch.getText());
       fieldId.setText(Integer.toString(suppliers.getId()));
       fieldName.setText(suppliers.getName());
       fieldCompanyName.setText(suppliers.getCompanyName());
       fieldEmail.setText(suppliers.getEmail());
       fieldPhone.setText(suppliers.getPhone());
       areaDescription.setText(suppliers.getDescription());
       
       }
        
    }
    public void setClick(javax.swing.JTable tableSupplier,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldCompanyName, javax.swing.JTextField fieldEmail, javax.swing.JTextField fieldPhone,javax.swing.JTextArea areaDescription){
       int row =tableSupplier.getSelectedRow();
       String tableClick=(tableSupplier.getModel().getValueAt(row,1).toString());
            
       suppliers.Search(tableClick);
       fieldId.setText(Integer.toString(suppliers.getId()));
       fieldName.setText(suppliers.getName());
       fieldCompanyName.setText(suppliers.getCompanyName());
       fieldEmail.setText(suppliers.getEmail());
       fieldPhone.setText(suppliers.getPhone());
       areaDescription.setText(suppliers.getDescription());
    }
   
    
     public void UpdateTable(javax.swing.JTable tableSupplier){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
            String sqlQuery="select * from tb_supplier order by id asc";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableSupplier.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
     }
     
     public void clear(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldId,javax.swing.JTextField fieldName, javax.swing.JTextField fieldCompanyName, javax.swing.JTextField fieldEmail, javax.swing.JTextField fieldPhone,javax.swing.JTextArea areaDescription){
         fieldSearch.setText("");
         fieldName.setText("");
         fieldCompanyName.setText("");
         fieldEmail.setText("");
         fieldPhone.setText("");
         areaDescription.setText("");
         
     }
     
}

