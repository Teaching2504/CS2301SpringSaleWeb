/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nttt.hibernatedemov2;

import com.nttt.repositories.impl.CategoryRepositoryImpl;


/**
 *
 * @author MY PC
 */
public class HibernateDemoV2 {

    public static void main(String[] args) {
        CategoryRepositoryImpl s1 = new CategoryRepositoryImpl();
        s1.getCate().forEach(c -> System.out.println(c.getName()));
    }
}
