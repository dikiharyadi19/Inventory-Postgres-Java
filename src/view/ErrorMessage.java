/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Dikki Haryadi
 */
public class ErrorMessage {
    public int showOption(String message, String title, Object[] option){
        return JOptionPane.showOptionDialog(null,message,title, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        
    }
}
