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
import java.sql.Date;

import net.proteanit.sql.DbUtils;
import view.ErrorMessage;

/**
 *
 * @author Dikki Haryadi
 */
public class Pembelian {
    private int id,product_id,quantity,price,supplier_id;
    private String name;
    private Date date_buy;
    private String message;
    private Koneksi koneksi=new Koneksi();
    private final ErrorMessage messageDialog=new ErrorMessage();
    
    
//##############################################################################
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceunit() {
        return price;
    }

    public void setPriceunit(int price) {
        this.price = price;
    }
    public Date getDate() {
        return date_buy;
    }

    public void setDate(Date date_buy) {
        this.date_buy = date_buy;
    }
    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Koneksi getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(Koneksi koneksi) {
        this.koneksi = koneksi;
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
                        sqlQuery="update tb_pembelian set name=?, product_id=?,  quantity=?, price=?,  date_buy=?,supplier_id=? where id=?";
                        
                        ps =connection.prepareStatement(sqlQuery);
                        ps.setString(1, name);
                        ps.setInt(2, product_id);
                        ps.setInt(3, quantity);
                        ps.setInt(4, price);
                        ps.setDate(5, date_buy);
                        ps.setInt(6,supplier_id);
                        ps.setInt(7, id);
                        totalSave=ps.executeUpdate();
                if(save)
                {
                    if(totalSave<1)
                    {
                        errorMessage =true;
                       message = "Failed save Data Pembelian";
                    }
                }
                
                ps.close();
                connection.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                message="cant opened table Pembelian";
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
                    sqlQuery="insert into tb_pembelian(name,product_id,quantity, price, date_buy, supplier_id) values(?,?,?,?,?,?)";
                    
                    
                    ps =connection.prepareStatement(sqlQuery);
                    ps.setString(1, name);
                    ps.setInt(2, product_id);
                    ps.setInt(3, quantity);
                    ps.setInt(4, price);                   
                    ps.setDate(5, date_buy);
                    ps.setInt(6,supplier_id);    
                    ps.executeUpdate();
                
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
            
            sqlQuery="delete from tb_pembelian where name=?";
            
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
    public boolean Search(String name)
    {
        boolean errorMessage=false;
        Connection connection;
        
                        
        this.id=0;
        this.name="";
        this.product_id=0;
        this.quantity=0;
        this.price=0;
        //this.totalprice=0;
        this.date_buy=null;
        this.supplier_id=0;        
        if((connection = koneksi.getConnection()) !=null)
        {
            PreparedStatement ps;
            ResultSet rset;
            
            String sqlQuery="select * from tb_pembelian where name=?";
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setString(1, name);
                rset=ps.executeQuery();
                
                rset.next();
                if(rset.getRow()>0)
                {
                    this.id=rset.getInt("id");
                    this.name =rset.getString("name");
                    this.product_id=rset.getInt("product_id");
                    this.quantity=rset.getInt("quantity");
                    this.price=rset.getInt("price");
                   // this.totalprice=rset.getInt("totalprice");
                    this.date_buy=rset.getDate("date_buy");
                    this.supplier_id=rset.getInt("supplier_id");
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
    public boolean UpdateTable(javax.swing.JTable tableReceiving){
       boolean errorMessage=false;
       Connection connection=null;
       PreparedStatement ps;
       ResultSet rset;
       try{
           String sqlQuery="select * from tb_pembelian";
           ps=connection.prepareStatement(sqlQuery);
           rset=ps.executeQuery();
           tableReceiving.setModel(DbUtils.resultSetToTableModel(rset));
       }catch(SQLException ex){
           ex.printStackTrace();
       }
        
       return !errorMessage;
    }
    
    
    
    
   
    
}
