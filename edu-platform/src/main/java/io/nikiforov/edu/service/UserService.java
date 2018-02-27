package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
}
