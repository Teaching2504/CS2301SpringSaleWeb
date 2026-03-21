/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.repositories.impl;

import com.nttt.hibernatedemov2.HibernateUtils;
import java.util.List;
import com.nttt.pojo.CartItem;
import com.nttt.pojo.OrderDetail;
import com.nttt.pojo.SaleOrder;
import java.util.Date;
import org.hibernate.Session;
/**
 *
 * @author MY PC
 */
public class ReceipRepositoryImpl {
    public void addReceipt(List<CartItem> carts){
        try (Session s  = HibernateUtils.getFACTORY().openSession()){
            SaleOrder receipt = new SaleOrder();
            receipt.setUserId(new UserRepositoryImpl().getUserByUsername("dhthanh"));
            receipt.setCreatedDate(new Date());
            s.persist(receipt);
            
            for( var c: carts){
                OrderDetail d = new OrderDetail();
                d.setQuantity(c.getQuantity());
                d.setUnitPrice(c.getPrice());
                d.setProductId(new ProductRepositoryImpl().getProductById(c.getId()));
                d.setOrderId(receipt);
                
                s.persist(d);
                
            }
        }
    }
}
