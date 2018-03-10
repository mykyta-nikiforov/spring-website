package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.model.StudentInfo;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    List<Student> getByGroupId(int id);

    void save(Student student);

    void save(StudentInfo studentInfo);

    void delete(int id);
}
