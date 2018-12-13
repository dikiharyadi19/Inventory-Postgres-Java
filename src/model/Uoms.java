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
public class Uoms {
    private int id;
    private String name,abbreviation,description;
    private String message;
    private Object[][] list;
    private final Koneksi koneksi=new Koneksi();
    private final ErrorMessage messageDialog=new ErrorMessage();
 //##############################################################################
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getAbbreviation()
    {
        return abbreviation;
    }
    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation=abbreviation;
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
            ResultSet rset;
            
            sqlQuery = "select * from tb_unit_of_measure where id=?";
            
            try {
             
                        save=true;
                        sqlQuery="update tb_unit_of_measure set name=?, abbreviation=?, description=? where id=?";
                        
                        ps =connection.prepareStatement(sqlQuery);
                        ps.setString(1, name);
                        ps.setString(2, abbreviation);
                        ps.setString(3, description);
                        ps.setInt(4, id);
                        
                        
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
                    sqlQuery="insert into tb_unit_of_measure (name,abbreviation,description) values(?,?,?)";
                    ps=connection.prepareStatement(sqlQuery);
                
                    ps.setString(1, name);
                    ps.setString(2, abbreviation);
                    ps.setString(3, description);
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
            
            sqlQuery="delete from tb_unit_of_measure where name=?";
            
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
        this.abbreviation="";
        this.description="";
        
        if((connection = koneksi.getConnection()) !=null)
        {
            PreparedStatement ps;
            ResultSet rset;
            
            String sqlQuery="select * from tb_unit_of_measure where name=?";
            try {
                ps=connection.prepareStatement(sqlQuery);
                ps.setString(1, name);
                rset=ps.executeQuery();
                
                rset.next();
                if(rset.getRow()>0)
                {
                    this.id =rset.getInt("id");
                    this.name=rset.getString("name");
                    this.abbreviation=rset.getString("abbreviation");
                    this.description=rset.getString("description");

                }else
                {
                    errorMessage=true;
                    message="id unit of measure"+id+"cant find";
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
    public boolean UpdateTable(javax.swing.JTable tableUom) 
    {
        boolean errorMessage=false;
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rset;
        try{
            String sqlQuery="select id,name,abbreviation,description from tb_unit_of_measure";
            ps=connection.prepareStatement(sqlQuery);
            rset=ps.executeQuery();
            tableUom.setModel(DbUtils.resultSetToTableModel(rset));
        
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
         return !errorMessage;
        
    }
//##############################################################################
}
