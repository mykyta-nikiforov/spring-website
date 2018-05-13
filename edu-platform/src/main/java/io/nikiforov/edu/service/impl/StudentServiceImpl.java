package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.*;
import io.nikiforov.edu.entity.*;
import io.nikiforov.edu.model.StudentInfo;
import io.nikiforov.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupService groupService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepository.findOne(id);
    }

    @Override
    public List<Student> getByGroupId(int id) {
        return studentRepository.findByGroupId(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student save(StudentInfo studentInfo) {
        Group group = groupService.getGroup(studentInfo.getGroupId());
        Student result = new Student(studentInfo, group); // Create Student from StudentInfo
        Set<Role> roleSet = new HashSet<>(); // Create roleSet and set it
        roleSet.add(roleService.getRole("STUDENT"));
        result.setRoles(roleSet);
        result.setPassword(passwordEncoder.encode(result.getPassword())); // Encode password
        return save(result); // Save the student
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public Student saveWithoutPassword(StudentInfo studentInfo) {
        Student student = getById(studentInfo.getId());
        Group group = groupService.getGroup(studentInfo.getGroupId());
        student.setEmail(studentInfo.getEmail());
        student.setName(studentInfo.getName());
        student.setSurname(studentInfo.getSurname());
        student.setPatronymic(studentInfo.getPatronymic());
        student.setGroup(group);
        return save(student);
    }

    @Override
    public void savePassword(StudentInfo studentInfo) {
        Student student = getById(studentInfo.getId());
        student.setPassword(passwordEncoder.encode(studentInfo.getPassword()));
        save(student);
    }
}