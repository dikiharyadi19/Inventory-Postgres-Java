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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Koneksi;
import model.Users;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author user
 */
public class UserController {
    private final Users user = new Users();
    private Koneksi koneksi=new Koneksi();
    
    Connection connection=null;
    PreparedStatement ps;
    ResultSet rset;
//##############################################################################
    public void update(com.toedter.calendar.JDateChooser dateDate,javax.swing.JTextField fieldName,javax.swing.JTextField fieldEmail,javax.swing.JPasswordField fieldPassword,javax.swing.JTextArea areaAddress,javax.swing.JComboBox comboRole){
        if(!fieldName.getText().equals("")){
            //String date=((JTextField)dateDate.getDateEditor().getUiComponent()).getText();
          java.sql.Date tanggal=new java.sql.Date(dateDate.getDate().getTime());
            
            user.setName(fieldName.getText());
            user.setDob(tanggal);
            user.setEmail(fieldEmail.getText());
            user.setPassword(fieldPassword.getText());
            user.setAddress(areaAddress.getText());
            user.setRole(comboRole.getSelectedItem().toString());
            user.update();
        }else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################
    public void save(com.toedter.calendar.JDateChooser dateDate,javax.swing.JTextField fieldName,javax.swing.JTextField fieldEmail,javax.swing.JTextField fieldPassword,javax.swing.JTextArea areaAddress,javax.swing.JComboBox comboRole){
        if (!fieldName.getText().equals(""))
        {
            //String date=((JTextField)dateDate.getDateEditor().getUiComponent()).getText();
           Date date=dateDate.getDate();
           java.sql.Date tanggal=new java.sql.Date(dateDate.getDate().getTime());
           
            user.setName(fieldName.getText());
            user.setDob( tanggal);
            user.setEmail(fieldEmail.getText());
            user.setPassword(fieldPassword.getText());
            user.setAddress(areaAddress.getText());
            user.setRole(comboRole.getSelectedItem().toString());
            user.save();
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################    
    public void delete(javax.swing.JTextField fieldName){
        if (!fieldName.getText().equals("")){
            user.delete(fieldName.getText());
        } else {
            JOptionPane.showMessageDialog(null, "NIM tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################    
    public void Search(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,com.toedter.calendar.JDateChooser dateDate,javax.swing.JTextField fieldEmail,javax.swing.JPasswordField fieldPassword,javax.swing.JTextArea areaAddress,javax.swing.JComboBox comboRole){
        if (!fieldSearch.getText().equals("")){
            user.Search(fieldSearch.getText());
           
            ((JTextField)dateDate.getDateEditor().getUiComponent()).setText(user.getDob().toString());
            fieldEmail.setText(user.getEmail());
            fieldPassword.setText(user.getPassword());
            areaAddress.setText(user.getAddress());
            comboRole.setSelectedItem(user.getRole());            
        } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################
    public void setClick(javax.swing.JTable tableUser,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,com.toedter.calendar.JDateChooser dateDate,javax.swing.JTextField fieldEmail,javax.swing.JPasswordField fieldPassword,javax.swing.JTextArea areaAddress,javax.swing.JComboBox comboRole){
        int row =tableUser.getSelectedRow();
        String tableClick=(tableUser.getModel().getValueAt(row,1).toString());
          
            user.Search(tableClick);
            
            fieldName.setText(user.getName());
            ((JTextField)dateDate.getDateEditor().getUiComponent()).setText(user.getDob().toString());
            fieldEmail.setText(user.getEmail());
            fieldPassword.setText(user.getPassword());
            areaAddress.setText(user.getAddress());
            comboRole.setSelectedItem(user.getRole());
    }
//##############################################################################
    public void UpdateTable(javax.swing.JTable tableProduct){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
            String sqlQuery="select * from tb_user order by id asc";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableProduct.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
//##############################################################################
    public void Clear(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,com.toedter.calendar.JDateChooser dateDate,javax.swing.JTextField fieldEmail,javax.swing.JPasswordField fieldPassword,javax.swing.JTextArea areaAddress,javax.swing.JComboBox comboRole){
            
            fieldSearch.setText("");
            fieldName.setText("");
            dateDate.setDate(null);
            fieldEmail.setText("");
            fieldPassword.setText("");
            areaAddress.setText("");
            comboRole.setSelectedIndex(0);
    }
//##############################################################################
    /*public void setCombo(javax.swing.JComboBox comboRole){
        try{
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        String querySql="select * from tb_user";
        ps=connection.prepareStatement(querySql);
        rset=ps.executeQuery();
        
        while(rset.next()){
            String name=rset.getString("role");
            comboRole.addItem(name);
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }   
    }*/
}
