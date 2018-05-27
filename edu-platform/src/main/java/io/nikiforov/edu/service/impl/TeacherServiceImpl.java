package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.TeacherRepository;
import io.nikiforov.edu.entity.*;
import io.nikiforov.edu.model.TeacherInfo;
import io.nikiforov.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
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
    public Teacher saveWithoutPassword(TeacherInfo teacherInfo) {
        Teacher result = getById(teacherInfo.getId());
        // find degree by id
        Degree degree = degreeService.findOne(teacherInfo.getDegreeId());
        // Set all new values
        result.setEmail(teacherInfo.getEmail());
        result.setSurname(teacherInfo.getSurname());
        result.setName(teacherInfo.getName());
        result.setPatronymic(teacherInfo.getPatronymic());
        result.setDegree(degree);
        return save(result);
    }

    @Override
    public void savePassword(TeacherInfo teacherInfo) {
        String password = teacherInfo.getPassword();
        Teacher teacher = getById(teacherInfo.getId());
        teacher.setPassword(passwordEncoder.encode(password));
        save(teacher);
    }

    @Override
    public void delete(int id) {
        teacherRepository.delete(id);
    }

    @Override
    public List<Teacher> findFreeCurators() {
        return teacherRepository.findFreeCurators();
    }

    @Override
    public Teacher save(UserDetails userDetails, TeacherInfo teacherInfo) {
        Teacher result = (Teacher) userDetails;
        result.setName(teacherInfo.getName());
        result.setSurname(teacherInfo.getSurname());
        result.setPatronymic(teacherInfo.getPatronymic());
        result.setEmail(teacherInfo.getEmail());
        return save(result);
    }

    @Override
    public void savePassword(UserDetails userDetails, TeacherInfo teacherInfo) {
        Teacher result = (Teacher) userDetails;
        result.setPassword(passwordEncoder.encode(teacherInfo.getPassword()));
        save(result);
    }
}