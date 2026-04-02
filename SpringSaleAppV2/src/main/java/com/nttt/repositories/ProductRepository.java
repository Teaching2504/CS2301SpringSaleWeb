/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.repositories;

import com.nttt.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MY PC
 */
public interface ProductRepository {
    List<Product> getProducts(Map<String, String> params);
    void addOrUpdateProduct(Product p);
}
