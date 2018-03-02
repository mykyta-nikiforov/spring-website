package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.RoleRepository;
import io.nikiforov.edu.dao.UserRepository;
import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.entity.User;
import io.nikiforov.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

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
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Cannot find email");
        } else{

            String role = user.getRoles().iterator().next().getRole();
            switch (role){
                case "TEACHER":
                    Set<Role> roles = new HashSet<>();
                    roles.add(roleRepository.findByRole("TEACHER"));
                    return new Teacher(user.getUsername(),
                            user.getPassword(), roles);
            }

        }
        return null;
    }
}