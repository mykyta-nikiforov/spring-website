package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);
}
