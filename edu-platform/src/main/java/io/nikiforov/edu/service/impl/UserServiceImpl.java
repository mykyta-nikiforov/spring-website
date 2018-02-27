package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.UserRepository;
import io.nikiforov.edu.entity.CustomUserDetails;
import io.nikiforov.edu.entity.User;
import io.nikiforov.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Email not found."));
        return optionalUser.map(CustomUserDetails::new).get();
    }
}
