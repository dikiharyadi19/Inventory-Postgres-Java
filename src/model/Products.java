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
public class Products {
    
    private String name;
    private int barcode,id;
    private String description;
    private int  stock,unit_of_measure_id, purchase_price,sale_price;
    private Object[][] list;
    private String message;
    private final Koneksi koneksi=new Koneksi();
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

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnit_of_measure_id() {
        return unit_of_measure_id;
    }

    public void setUnit_of_measure_id(int unit_of_measure_id) {
        this.unit_of_measure_id = unit_of_measure_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(int purchase_price) {
        this.purchase_price = purchase_price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Object[][] getList()
    {
        return list;
    }
    
    public void setList(Object[][] list)
    {
        this.list = list;
    }
    
//##############################################################################
     public boolean update()
    {
        boolean errorMessage=false;
        Connection connection;
        if((connection = koneksi.getConnection()) !=null)
        {   int totalSave=0;
            boolean save=true;
            String sqlQuery="";
            
            PreparedStatement ps;
            ResultSet rset;
         
            try {
              
                        save=true;
                        sqlQuery="update tb_product set barcode=?,name=?,description=?,unit_of_measure_id=?, stock=?, purchase_price=?, sale_price=? where id=?";
                        
                        
                        ps =connection.prepareStatement(sqlQuery);
                        ps.setInt(1, barcode);
                        ps.setString(2, name);
                        ps.setString(3, description);
                        ps.setInt(4, unit_of_measure_id);
                        ps.setInt(5,stock);
                        ps.setInt(6, purchase_price);
                        ps.setInt(7, sale_price);
                        ps.setInt(8, id);
                        totalSave=ps.executeUpdate();
                    
                
                if(save)
                {
                    if(totalSave<1)
                    {
                        errorMessage =true;
                       message = "Failed save Data product";
                    }
                }
                
                ps.close();
                connection.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                message="cant opened table product";
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
            try {
            int totalSave=0;
            boolean save=false;
            String sqlQuery="";
            
            PreparedStatement ps;
            ResultSet rset;
           
                    save=true;
                    sqlQuery="insert into tb_product(barcode,name,description,unit_of_measure_id,stock,purchase_price,sale_price) values(?,?,?,?,?,?,?)";
                    
                    
                    ps=connection.prepareStatement(sqlQuery);
                    
                
                    ps.setInt(1, barcode);
                    ps.setString(2, name);
                    ps.setString(3, description);
                    ps.setInt(4, unit_of_measure_id);
                    ps.setInt(5, stock);
                    ps.setInt(6, purchase_price);
                    ps.setInt(7, sale_price);
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
    public boolean delete(int Barcode)
    {
        boolean errorMessage=false;
        Connection connection;
        
        if((connection =koneksi.getConnection())!=null)
        {
            int totalDelete;
            String sqlQuery;
            PreparedStatement ps;
            sqlQuery="delete from tb_product cascade where barcode=?";
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setInt(1, Barcode);
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
    public boolean Search(int barcode)
    {
        boolean errorMessage=false;
        Connection connection;
        
        this.id=0;
        this.barcode=0;
        this.name="";
        this.description="";
        this.unit_of_measure_id=0;
        this.stock=0;
        this.purchase_price=0;
        this.sale_price=0;
        
        if((connection = koneksi.getConnection()) !=null)
        {
            PreparedStatement ps;
            ResultSet rset;
            
            String sqlQuery="select * from tb_product where barcode=?";
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setInt(1, barcode);
                rset=ps.executeQuery();
                
                rset.next();
                if(rset.getRow()>0)
                {
                    this.id=rset.getInt("id");
                    this.barcode=rset.getInt("barcode");
                    this.name=rset.getString("name");
                    this.description=rset.getString("description");
                    this.unit_of_measure_id=rset.getInt("unit_of_measure_id");
                    this.stock=rset.getInt("stock");
                    this.purchase_price=rset.getInt("purchase_price");
                    this.sale_price=rset.getInt("sale_price");
                }else
                {
                    errorMessage=true;
                    message="name"+name+"cant find";
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
    public boolean UpdateTable(javax.swing.JTable tableProduct){
       boolean errorMessage=false;
       Connection connection=null;
       PreparedStatement ps;
       ResultSet rset;
       try{
           String sqlQuery="select * from tb_product";
           ps=connection.prepareStatement(sqlQuery);
           rset=ps.executeQuery();
           tableProduct.setModel(DbUtils.resultSetToTableModel(rset));
       }catch(SQLException ex){
           ex.printStackTrace();
       }
        
       return !errorMessage;
    }
//##############################################################################
public boolean readData(){
    boolean errorMessage=false;
    Connection connection;
    list=new Object[0][0];
    
    if((connection = koneksi.getConnection()) !=null){
        String sqlQuery="select id,name from tb_unit_of_measure";
        PreparedStatement ps;
        ResultSet rset;
        
        try{
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            
           rset.next();
                //rset.last();
            list= new Object[rset.getRow()][2];
            
            if(rset.getRow()>0){
            //    rset.first();
                int i=0;
                do{
                    list[i]=new Object[]{rset.getString("id"),rset.getString("name")};
                    i++;
                }while(rset .next());
            }
            ps.close();
            rset.close();
            connection.close();
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    return true;
}
//##############################################################################
}
