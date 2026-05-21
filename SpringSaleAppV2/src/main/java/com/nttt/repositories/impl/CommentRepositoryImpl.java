/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttt.pojo.Comment;
import com.nttt.repositories.CommentRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author MY PC
 */
@Repository
@Transactional
public class CommentRepositoryImpl  implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Comment> getComments(int productId){
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Comment addComment(Comment c) {
        Session session = this.factory.getObject().getCurrentSession();
        session.persist(c);
        return c;
    }

}



