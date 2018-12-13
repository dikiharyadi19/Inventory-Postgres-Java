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
 * @author user
 */
public class Penjualan {

    private int id,product_id,price,quantity,customer_id;
    private Date date_sell;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getDate_sell() {
        return date_sell;
    }

    public void setDate_sell(Date date_sell) {
        this.date_sell = date_sell;
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
                        sqlQuery="update tb_penjualan set customer_id=?,name=? product_id=?,  price=?, quantity=?, date_sell=? where id=?";
                        
                        ps =connection.prepareStatement(sqlQuery);
                        ps.setInt(1, customer_id);
                        ps.setString(2,name);
                        ps.setInt(3, product_id);
                        ps.setInt(4, price);
                        ps.setInt(5, quantity);
                        ps.setDate(6, date_sell);
                        ps.setInt(7, id);
                        totalSave=ps.executeUpdate();
                if(save)
                {
                    if(totalSave<1)
                    {
                        errorMessage =true;
                       message = "Failed save Data Receiving";
                    }
                }
                
                ps.close();
                connection.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                message="cant opened table Receiving";
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
                    sqlQuery="insert into tb_penjualan(customer_id,name,product_id,price,quantity,date_sell) values(?,?,?,?,?,?)";
                    
                    
                    ps =connection.prepareStatement(sqlQuery);
                    
                  
                    ps.setInt(1, customer_id);
                    ps.setString(2, name);
                    ps.setInt(3, product_id);
                    ps.setInt(4, price);
                    ps.setInt(5, quantity);
                    ps.setDate(6, date_sell);   
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
     public boolean delete(int product_id)
    {
        boolean errorMessage=false;
        Connection connection;
        
        if((connection =koneksi.getConnection())!=null)
        {
            int totalDelete;
            String sqlQuery;
            PreparedStatement ps;
            
            sqlQuery="delete from tb_penjualan where product_id=?";
            
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setInt(1, product_id);
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
    public boolean Search(int id)
    {
        boolean errorMessage=false;
        Connection connection;
        
                        
        this.id=0;
        this.customer_id=0;
        this.name="";
        this.product_id=0;
        this.price=0;
        this.quantity=0;
        this.date_sell=null;        
        if((connection = koneksi.getConnection()) !=null)
        {
            PreparedStatement ps;
            ResultSet rset;
            
            String sqlQuery="select * from tb_penjualan where id=?";
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setInt(1, id);
                rset=ps.executeQuery();
                
                rset.next();
                if(rset.getRow()>0)
                {
             
                    this.id=rset.getInt("id");
                    this.customer_id=rset.getInt("customer_id");
                    this.name=rset.getString("name");
                    this.product_id=rset.getInt("product_id");
                    this.price=rset.getInt("price");
                    this.quantity=rset.getInt("quantity");
                    this.date_sell=rset.getDate("date_sell");
                    
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
    public boolean UpdateTable(javax.swing.JTable tableTransaction){
       boolean errorMessage=false;
       Connection connection=null;
       PreparedStatement ps;
       ResultSet rset;
       try{
           String sqlQuery="select * from tb_penjualan";
           ps=connection.prepareStatement(sqlQuery);
           rset=ps.executeQuery();
           tableTransaction.setModel(DbUtils.resultSetToTableModel(rset));
       }catch(SQLException ex){
           ex.printStackTrace();
       }
        
       return !errorMessage;
    }
    
}
