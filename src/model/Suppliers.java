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
import net.proteanit.sql.DbUtils;
import view.ErrorMessage;

/**
 *
 * @author Dikki Haryadi
 */
public class Suppliers {
    private int id;
    private String name,company_name,email,phone,description;
    private String message;
    private Object[][] list;
    private final Koneksi koneksi=new Koneksi();
    private final ErrorMessage messageDialog=new ErrorMessage();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public Object[][] getList()
    {
        return list;
    }
    public void setList(Object[][] list)
    {
        this.list=list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
     
      
    //fungsi untuk menyimpan data
     public boolean update()
    {
        boolean errorMessage=false;
        Connection connection;
        if((connection = koneksi.getConnection()) !=null)
        {   int totalSave=0;
            boolean save=true;
            String sqlQuery="";
            PreparedStatement ps;            
            try {
           
                        save=true;
                        sqlQuery="update tb_supplier set name=?, company_name=?, email=?, phone=?, description=? where id=?";
                        
                        ps =connection.prepareStatement(sqlQuery);
                        ps.setString(1, name);
                        ps.setString(2, company_name);
                        ps.setString(3, email);
                        ps.setString(4, phone);
                        ps.setString(5, description);
                        ps.setInt(6, id);
                        
                        
                        totalSave=ps.executeUpdate();
                    
                
                if(save)
                {
                    if(totalSave<1)
                    {
                        errorMessage =true;
                       message = "Failed save Data Supplier";
                    }
                }
                
                ps.close();
                connection.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                message="cant opened table Supplier";
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
            
           sqlQuery ="select * from tb_supplier where name=?";
           
            try {
              
                    save=true;
                    sqlQuery="insert into tb_supplier(id,name,company_name ,email, phone ,description) values(?,?,?,?,?,?)";
                    
                    
                    ps=connection.prepareStatement(sqlQuery);
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, company_name);
                    ps.setString(4, email);
                    ps.setString(5, phone);
                    ps.setString(6, description);
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
            
            sqlQuery="delete from tb_supplier where name=?";
            
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
        
        this.id=0;
        this.name="";
        this.company_name="";
        this.email="";
        this.phone="";
        this.description="";
        
        if((connection = koneksi.getConnection()) !=null)
        {
            PreparedStatement ps;
            ResultSet rset;
            
            String sqlQuery="select * from tb_supplier where name=?";
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setString(1,fieldSearch);
                rset=ps.executeQuery();
                
                rset.next();
                if(rset.getRow()>0)
                {
                    this.id=rset.getInt("id");
                    this.name=rset.getString("name");
                    this.company_name=rset.getString("company_name");
                    this.email=rset.getString("email");
                    this.phone=rset.getString("phone");
                    this.description=rset.getString("description");

                }else
                {
                    errorMessage=true;
                    message="name supplier"+name+"cant find";
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
    
    public boolean UpdateTable(javax.swing.JTable tableSupplier) 
    {
        boolean errorMessage=false;
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        try{
            String sqlQuery="select id,name,company_name ,email, phone ,description from tb_supplier";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableSupplier.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
         return !errorMessage;
        
    }
    
    
    
}
