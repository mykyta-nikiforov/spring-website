package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.StudentRepository;
import io.nikiforov.edu.dao.UserRepository;
import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.model.StudentInfo;
import io.nikiforov.edu.service.RoleService;
import io.nikiforov.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getByGroupId(int id) {
        return studentRepository.findByGroupId(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void save(StudentInfo studentInfo) {
        // Create Student from StudentInfo
        Student result = new Student(studentInfo);
        // Create roleSet and set it
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRole("STUDENT"));
        result.setRoles(roleSet);
        // Encode password
        result.setPassword(passwordEncoder.encode(result.getPassword()));
        // Save the student
        save(result);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }
}
