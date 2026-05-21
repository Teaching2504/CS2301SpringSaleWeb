/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.services.impl;

import com.nttt.repositories.CommentRepository;
import com.nttt.repositories.ProductRepository;
import com.nttt.repositories.UserRepository;
import com.nttt.services.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttt.pojo.Comment;
import java.util.Date;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author MY PC
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ProductRepository prodRepo;

    @Override
    public List<Comment> getComments(int productId) {
        return this.commentRepo.getComments(productId);
    }

    @Override
    public Comment addComment(int productId, String content) {
        Comment c = new Comment();
        c.setContent(content);
        c.setCreatedDate(new Date());
        c.setUserId(this.userRepo.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        c.setProductId(this.prodRepo.getProductById(productId));
        
        return this.commentRepo.addComment(c);
    }
}
