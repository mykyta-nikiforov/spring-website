package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.RoleRepository;
import io.nikiforov.edu.dao.StudentRepository;
import io.nikiforov.edu.dao.TeacherRepository;
import io.nikiforov.edu.dao.UserRepository;
import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Student;
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
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

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
            Set<Role> roles = new HashSet<>();
            switch (role){
                case "TEACHER":
                    roles.add(roleRepository.findByRole("TEACHER"));
                    Teacher teacher = teacherRepository.getOne(user.getId());
                    return teacher;
                case "STUDENT":
                    roles.add(roleRepository.findByRole("STUDENT"));
                    Student student = studentRepository.getOne(user.getId());
                    return student;
            }
        }
        return null;
    }
}