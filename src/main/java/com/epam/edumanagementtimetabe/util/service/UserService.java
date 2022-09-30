package com.epam.edumanagementtimetabe.util.service;

import com.epam.edumanagementtimetabe.util.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User save(User user);

    List<User> findAll();

    User findByEmail(String email);
}
