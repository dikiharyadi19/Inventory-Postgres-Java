/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.Encryption;
import model.Users;

/**
 *
 * @author user
 */
public class LoginController {
    private final Encryption enkripsi=new Encryption();
    private final Users user=new Users();
    
    public boolean validasi(javax.swing.JTextField fieldUsername, javax.swing.JPasswordField fieldPassword)
    {   
        boolean valid=false;
        String hashedInputPassword="";
        
        if(!fieldUsername.getText().equals(""))
        {
            if(user.Search(fieldUsername.getText()))
            {
                try{
                    hashedInputPassword = enkripsi.hashMD5(new String(fieldPassword.getPassword()));
                   
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                    
                }
                if(user.getPassword().equalsIgnoreCase(hashedInputPassword))
                {
                    valid=true;
                }else{
                   
                    JOptionPane.showMessageDialog(null, "User Name r password Error", "", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                
                if(user.getMessage().substring(0, 3).equalsIgnoreCase("name"))
                        {
                            JOptionPane.showMessageDialog(null, "User Name o password Error", "", JOptionPane.ERROR_MESSAGE);
                        }
                else
                        {
                            JOptionPane.showMessageDialog(null, "User Name orr password Error", "", JOptionPane.ERROR_MESSAGE);
                        }
            }
            
        }
        
        
        return valid;
    }
}
