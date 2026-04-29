/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.services.impl;

import com.nttt.pojo.CartItem;
import com.nttt.repositories.ReceiptRepository;
import com.nttt.services.ReceiptService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MY PC
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{
    @Autowired
    private ReceiptRepository receiptRepo;
    
    
    @Override
    public void addReceipt(List<CartItem> carts) {
        this.receiptRepo.addReceipt(carts);
    }
    
}
