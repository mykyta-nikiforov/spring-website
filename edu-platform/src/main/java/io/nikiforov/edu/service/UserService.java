package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.User;
import io.nikiforov.edu.model.UserSettingsModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);

    User saveUserSettings(UserDetails userDetails, UserSettingsModel userSettingsModel);
}