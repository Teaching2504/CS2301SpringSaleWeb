/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttt.repositories;

import com.nttt.pojo.CartItem;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MY PC
 */
@Repository
public interface ReceiptRepository {
    void addReceipt(List<CartItem> carts);
}
