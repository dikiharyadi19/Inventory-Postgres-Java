/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Dikki Haryadi
 */
public class Koneksi {
    private final String url="jdbc:postgresql://localhost/inventory";
    private final String user="postgres";
    private final String password="1111";



    
    public Connection getConnection()
    {
        
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url,user,password);
            System.out.println("Succesfully Connected to server ");
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        
        
        return conn;
    }
}
