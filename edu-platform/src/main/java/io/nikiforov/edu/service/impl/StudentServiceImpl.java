package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.StudentRepository;
import io.nikiforov.edu.dao.UserRepository;
import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }
}
