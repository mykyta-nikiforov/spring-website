package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.*;
import io.nikiforov.edu.entity.*;
import io.nikiforov.edu.model.UserSettingsModel;
import io.nikiforov.edu.service.StudentService;
import io.nikiforov.edu.service.TeacherService;
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
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

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

    // Very bad code, TODO rewrite
    @Override
    public User saveUserSettings(UserDetails userDetails, UserSettingsModel userSettingsModel) {
        User user = (User) userDetails;
        user.setEmail(userSettingsModel.getEmail());
        user.setPassword(userSettingsModel.getPassword());
        save(user);

        String role = user.getRoles().iterator().next().getRole();
        if (role.equals("TEACHER")) {
            Teacher teacher = (Teacher) user;
            teacher.setName(userSettingsModel.getName());
            teacher.setSurname(userSettingsModel.getSurname());
            teacher.setPatronymic(userSettingsModel.getPatronymic());
            System.out.println("in if. " + teacher);
            teacherService.save(teacher);

        } else if (role.equals("STUDENT")) {
            Student student = (Student) user;
            student.setName(userSettingsModel.getName());
            student.setSurname(userSettingsModel.getSurname());
            student.setPatronymic(userSettingsModel.getPatronymic());
            studentService.save(student);
        }
        System.out.println("userSettingsModel: " + userSettingsModel);

        return null;
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