/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.services;

import com.nttt.pojo.CartItem;
import java.util.List;

/**
 *
 * @author MY PC
 */
public interface ReceiptService {
    void addReceipt(List<CartItem> carts);
}
