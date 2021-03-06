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
import model.Uoms;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Dikki Harryadi
 */
public class UomController {
    private final Uoms uom = new Uoms();
    private Koneksi koneksi=new Koneksi();
 //##############################################################################
     public void update(javax.swing.JTextField fieldName, javax.swing.JTextField fieldAbbreviation, javax.swing.JTextArea areaDescription){
        if (!fieldName.getText().equals(""))
        {
   
            uom.setName(fieldName.getText());
            uom.setAbbreviation(fieldAbbreviation.getText());
            uom.setDescription(areaDescription.getText());
            uom.update();
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################
    public void save(javax.swing.JTextField fieldName, javax.swing.JTextField fieldAbbreviation, javax.swing.JTextArea areaDescription){
        if (!fieldName.getText().equals(""))
        {   
           
            uom.setName(fieldName.getText());
            uom.setAbbreviation(fieldAbbreviation.getText());
            uom.setDescription(areaDescription.getText());
            uom.save(); 
        }
        else{
         JOptionPane.showMessageDialog(null, "name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
//##############################################################################
    public void delete(javax.swing.JTextField fieldName){
        if (!fieldName.getText().equals("")){
            uom.delete(fieldName.getText());
            
        } else {
            JOptionPane.showMessageDialog(null, "NIM tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
 //##############################################################################
    public void Search(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName, javax.swing.JTextField fieldAbbreviation, javax.swing.JTextArea areaDescription){
       if(!fieldSearch.getText().equals("")){
      
       uom.Search(fieldSearch.getText());
       
       fieldName.setText(uom.getName());
       fieldAbbreviation.setText(uom.getAbbreviation());
       areaDescription.setText(uom.getDescription());  
       } else {
            JOptionPane.showMessageDialog(null, "Name tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
 //##############################################################################
     public void setClick(javax.swing.JTable tableUom,javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName, javax.swing.JTextField fieldAbbreviation, javax.swing.JTextArea areaDescription){
       int row =tableUom.getSelectedRow();
       String tableClick=(tableUom.getModel().getValueAt(row,1).toString());
            
       uom.Search(tableClick);
       
       fieldName.setText(uom.getName());
       fieldAbbreviation.setText(uom.getAbbreviation());
       areaDescription.setText(uom.getDescription()); 
    }
//##############################################################################
    public void UpdateTable(javax.swing.JTable tableUom){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        connection=koneksi.getConnection();
        try{
            String sqlQuery="select * from tb_unit_of_measure order by id asc";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableUom.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
     }
//##############################################################################
    public void clear(javax.swing.JTextField fieldSearch,javax.swing.JTextField fieldName,javax.swing.JTextField fieldAbbreviation ,javax.swing.JTextArea areaDescription){
         fieldSearch.setText("");
         
         fieldName.setText("");
         fieldAbbreviation.setText("");
         areaDescription.setText("");
        
     }
//##############################################################################
}
