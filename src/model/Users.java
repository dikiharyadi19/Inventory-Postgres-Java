/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
import view.ErrorMessage;

/**
 *
 * @author Dikki Haryadi
 */
public class Users {
    private int id;
    private String name,email,password,address,role;
    private Date dob;
    private String message;
    private Object[][] list;
    private final Koneksi koneksi= new Koneksi();
    private final ErrorMessage messageDialog=new ErrorMessage();
//##############################################################################
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role=role;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message=message;
    }
    
    public Object[][] getList()
    {
        return list;
    }
    public void setList(Object[][] list)
    {
        this.list=list;
    }
//##############################################################################   
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
                        sqlQuery="update tb_user set  name=?,dob=?,email=?,password=?,address=?, role=? where id=?";
                        
                        ps =connection.prepareStatement(sqlQuery);
                       
                        ps.setString(1, name);
                        ps.setDate(2, dob);
                        ps.setString(3, email);
                        ps.setString(4, password);
                        ps.setString(5, address);
                        ps.setString(6, role);
                        ps.setInt(7, id);
                        totalSave=ps.executeUpdate();
                    
                
                if(save)
                {
                    if(totalSave<1)
                    {
                        errorMessage =true;
                       message = "Failed save Data User";
                    }
                }
                
                ps.close();
                connection.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                message="cant opened table Users";
            }
            
        }else
        {
            errorMessage=true;
            message="cant connected to server";
        }
        
        
        return !errorMessage;
    }
//##############################################################################
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
                    sqlQuery="insert into tb_user(name,dob,email,password,address,role) values(?,?,?,?,?,?)";
                    
                    
                    ps=connection.prepareStatement(sqlQuery);
                    
                   
                    ps.setString(1, name);
                    ps.setDate(2, dob);
                    ps.setString(3, email);
                    ps.setString(4, password);
                    ps.setString(5, address);
                    ps.setString(6, role);
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
//##############################################################################
     public boolean delete(String name)
    {
        boolean errorMessage=false;
        Connection connection;
        
        if((connection =koneksi.getConnection())!=null)
        {
            int totalDelete;
            String sqlQuery;
            PreparedStatement ps;
            sqlQuery="delete from tb_user where name=?";
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
     
//##############################################################################
    public boolean Search(String Name)
    {
        boolean errorMessage=false;
        Connection connection;
        this.id=0;
        this.name="";
        this.dob=null;
        this.email="";
        this.password="";
        this.role="";
        this.address="";
        this.role="";
        
        if((connection = koneksi.getConnection()) !=null)
        {
            PreparedStatement ps;
            ResultSet rset;
            
            String sqlQuery="select * from tb_user where name=?";
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setString(1, Name);
                rset=ps.executeQuery();
                
                rset.next();
                if(rset.getRow()>0)
                {
                    this.id=rset.getInt("id");
                    this.name=rset.getString("name");
                    this.dob=rset.getDate("dob");
                    this.email=rset.getString("email");
                    this.password=rset.getString("password");
                    this.role=rset.getString("role");
                    this.address=rset.getString("address");
                    this.role=rset.getString("role");

                }else
                {
                    errorMessage=true;
                    message="id unit of measure"+name+"cant find";
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
    
//##############################################################################
     public boolean UpdateTable(javax.swing.JTable tableUser){
       boolean errorMessage=false;
       Connection connection=null;
       PreparedStatement ps;
       ResultSet rset;
       try{
           String sqlQuery="select * from tb_user";
           ps=connection.prepareStatement(sqlQuery);
           rset=ps.executeQuery();
           tableUser.setModel(DbUtils.resultSetToTableModel(rset));
       }catch(SQLException ex){
           ex.printStackTrace();
       }
        
       return !errorMessage;
    }
   
//##############################################################################    
   
}
