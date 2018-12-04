/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.ButtonTabComponent;
//import view.FormLogins;
import view.TabCustomer;
import view.TabProduct;

import view.TabPembelian;
import view.TabReport;
import view.TabSupplier;
import view.TabPenjualan;
import view.TabUom;
import view.TabUser;

/**
 *
 * @author user
 */
public class MainFrameController {
    TabCustomer tabCustomer=new TabCustomer();
    TabProduct tabProduct=new TabProduct();
  
    TabPembelian tabReceiving=new TabPembelian();
    TabReport tabReport=new TabReport();
    TabSupplier tabSupplier=new TabSupplier();
    TabUom tabUom=new TabUom();
    TabUser tabUser=new TabUser();
    TabPenjualan tabTransaction=new TabPenjualan();
   
            
    public void setVisible(javax.swing.JLabel customer,javax.swing.JLabel product,javax.swing.JLabel supplier,javax.swing.JLabel uom,javax.swing.JLabel user,javax.swing.JLabel receiving,javax.swing.JLabel cashier){
        customer.setVisible(false);
        product.setVisible(false);
        supplier.setVisible(false);
        uom.setVisible(false);
        user.setVisible(false);
        receiving.setVisible(false);

        cashier.setVisible(false);
    }
    public void setClick(boolean click,javax.swing.JTabbedPane tabbedPane,javax.swing.JLabel customer,javax.swing.JLabel product,javax.swing.JLabel supplier,javax.swing.JLabel uom,javax.swing.JLabel user,javax.swing.JLabel receiving,javax.swing.JLabel productStock,javax.swing.JLabel cashier){
       if(click){
           customer.setVisible(true);
           tabbedPane.addTab("Customer Data",customer);
           tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(customer),new ButtonTabComponent(tabbedPane));
       }
    }
}
