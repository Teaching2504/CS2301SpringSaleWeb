/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.repositories.impl;

import com.nttt.hibernatedemov2.HibernateUtils;
import com.nttt.pojo.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
/**
 *
 * @author MY PC
 */
public class UserRepositoryImpl {
    public User getUserByUsername(String username){
        try (Session s = HibernateUtils.getFACTORY().openSession()){
            Query query = s.createNamedQuery("User.findByUsername",User.class);
            query.setParameter("username", username);
            
            return (User) query.getSingleResult();
        }
    }
}
