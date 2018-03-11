package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.TeacherRepository;
import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.model.TeacherInfo;
import io.nikiforov.edu.service.RoleService;
import io.nikiforov.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleService roleService;

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
    public void save(TeacherInfo teacherInfo) {
        // Create Teacher from TeacherInfo
        Teacher result = new Teacher(teacherInfo);
        // Create roleSet and set it
        Set<Role> rolesSet = new HashSet<>();
        rolesSet.add(roleService.getRole("TEACHER"));
        result.setRoles(rolesSet);
        // Encode password
        result.setPassword(passwordEncoder.encode(result.getPassword()));
        // Save the teacher
        save(result);
    }

    @Override
    public void delete(int id) {
        teacherRepository.delete(id);
    }
}