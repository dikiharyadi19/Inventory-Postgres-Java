/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import view.ErrorMessage;

/**
 *
 * @author Dikki Haryadi
 */
public class Customers {
    private int id;
    private String name,email,phone,address;
  
    private String message;
    private Object[][] list;
    private final Koneksi koneksi=new Koneksi();
    private final ErrorMessage MessageDialog=new ErrorMessage();
    private TableModel tableCustomer;
    //init untuk semua fungsi

    public TableModel getTableCustomer() {
        return tableCustomer;
    }

    public void setTableCustomer(TableModel tableCustomer) {
        this.tableCustomer = tableCustomer;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[][] getList() {
        return list;
    }

    public void setList(Object[][] list) {
        this.list = list;
    }
   
    
    
    //fungsi untuk menyimpan data
     public boolean update()
    {
        boolean errorMessage=false;
        Connection connection;
        if((connection = koneksi.getConnection()) !=null)
        {  
           
            int totalSave=0;
            boolean save=true;
            String sqlQuery="";
            
            PreparedStatement ps;
            ResultSet rset;
            try {
                save=true;
                        sqlQuery="update tb_customer set name=?,email=?, phone=?, address=? where id=?";
                        
                        ps =connection.prepareStatement(sqlQuery);
                        ps.setString(1, name);
                        ps.setString(2, email);
                        ps.setString(3, phone);
                        ps.setString(4, address);
                        ps.setInt(5, id);
                
                        ps.executeUpdate();
                if(save)
                {
                    if(totalSave<1)
                    {
                        errorMessage =true;
                       message = "Failed save Data Customer";
                    }
                }
                
                ps.close();
                connection.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
                message="cant opened table customer";
            }
            
        }else
        {
            errorMessage=true;
            message="cant connected to server";
        }
        return !errorMessage;
    }
    
    public boolean save()
    {
        boolean errorMessage=false;
        Connection connection;
        
        if((connection = koneksi.getConnection())!=null)
        {
            int totalSave=0;
            boolean save=false;
            String sqlQuery="";
            PreparedStatement ps;
            ResultSet rset;           
           
            try {
                    save=true;
                    sqlQuery="insert into tb_customer(id,name, email, phone, address) values(?,?,?,?,?)";
                    
                    
                    ps=connection.prepareStatement(sqlQuery);
                    ps.setInt(1,id);
                    ps.setString(2,name);
                    ps.setString(3, email);
                    ps.setString(4, phone);
                    ps.setString(5, address);
                    
                    totalSave=ps.executeUpdate();
                    
                
                if(save)
                {
                    if(totalSave<1)
                    {
                        errorMessage=true;
                        message="failed save data";
                    }
                }
                ps.close();
          
                connection.close();
                
                
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return !errorMessage;
    }
    
    public boolean delete(String name)
    {
        boolean errorMessage=false;
        Connection connection;
        
        if((connection =koneksi.getConnection())!=null)
        {
            int totalDelete;
            String sqlQuery;
            PreparedStatement ps;
            
            sqlQuery="delete from tb_customer where name=?";
            
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setString(1, name);
                totalDelete=ps.executeUpdate();
            
                if(totalDelete<1)
                {
                    errorMessage=true;
                    message="data tidak ditemukan";
                }
                
                ps.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
             }
            
            
        }else{
            errorMessage=true;
            message="cant connected to server";
        }
        
        
        return !errorMessage;
    }
     public boolean Search(String fieldSearch)
    {
        boolean errorMessage=false;
        Connection connection;
        
        this.name="";
        this.email="";
        this.phone="";
        this.address="";
        
        if((connection = koneksi.getConnection()) !=null)
        {
            PreparedStatement ps;
            ResultSet rset;
            
            String sqlQuery="select * from tb_customer where name=?";
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setString(1, fieldSearch);
                rset=ps.executeQuery();
                
                rset.next();
                if(rset.getRow()>0)
                {
                    this.id=rset.getInt("id");
                    this.name=rset.getString("name");
                    this.email=rset.getString("email");
                    this.phone=rset.getString("phone");
                    this.address=rset.getString("address");
                    
                }else
                {
                    errorMessage=true;
                    message="id customer"+name+"cant find";
                }
                
                ps.close();
                rset.close();
                connection.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            errorMessage=true;
            message="cant connected to server";
            
        }
        
        return !errorMessage;
    }
    
    
 
    public boolean UpdateTable() 
    {
        boolean errorMessage=false;
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        try{
            String sqlQuery="select id ,name Nama,email Email,address Alamat from tb_customer";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableCustomer=DbUtils.resultSetToTableModel(rset);
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
         return !errorMessage;
        
    }
    
    
    
}


