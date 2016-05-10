/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g2d.model;

import com.g2d.domain.Product;
import com.g2d.domain.VIP;
import com.g2d.domain.Customer;

/**
 *
 * @author Administrator
 */
public class OrderService {
    public double order(Customer c, Product p , int q){
        double rtn = 0;
        rtn = p.getUntiPrice() * q ;
        //判斷是不是VIP
        if((p.getClass() == Product.class) && c instanceof VIP){
            VIP vip = (VIP) c;
            rtn = rtn * (100-vip.getDiscount())/100;
        }
        return rtn ;
    }
    
}
