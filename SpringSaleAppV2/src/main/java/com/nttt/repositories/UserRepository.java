/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttt.repositories;

import com.nttt.pojo.User;

/**
 *
 * @author MY PC
 */
public interface UserRepository {
    User getUserByUsername(String username);
    User addUser(User u);
}
