/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g2d.test;

import com.g2d.domain.Customer;
import com.g2d.domain.Go2DrinkException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TestEquals {
    public static void main(String[] args) {
        
        try {
            Customer c1 = new Customer( "John","123456");
            Customer c2 = new Customer( "John","123456");
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c1 == c2);  // == 是判定這兩個物件是否是參考到同一個記憶體位置
            System.out.println(c1.equals(c2));
        } catch (Go2DrinkException ex) {
            Logger.getLogger(TestEquals.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
