/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.repositories.impl;

import com.nttt.hibernatedemov2.HibernateUtils;
import com.nttt.pojo.Category;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MY PC
 */
public class CategoryRepositoryImpl {
    public List<Category> getCate(){
        try (Session s = HibernateUtils.getFACTORY().openSession()){
            Query q = s.createQuery("FROM Category", Category.class);
            return q.getResultList();
            
        }
    }
}
