package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.TeacherRepository;
import io.nikiforov.edu.entity.*;
import io.nikiforov.edu.model.TeacherInfo;
import io.nikiforov.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleService roleService;

    @Autowired
    DegreeService degreeService;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(int id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher save(TeacherInfo teacherInfo) {
        // find degree by id
        Degree degree = degreeService.findOne(teacherInfo.getDegreeId());
        // Create Teacher from TeacherInfo and degree
        Teacher result = new Teacher(teacherInfo, degree);
        Set<Role> rolesSet = new HashSet<>(); // Create roleSet and set it
        rolesSet.add(roleService.getRole("TEACHER"));
        result.setRoles(rolesSet);
        result.setPassword(passwordEncoder.encode(result.getPassword())); // Encode password
        save(result); // Save the teacher
        return result;
    }

    @Override
    public void delete(int id) {
        teacherRepository.delete(id);
    }
}