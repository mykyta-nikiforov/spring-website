package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Student;
import io.nikiforov.edu.model.StudentInfo;
import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student getById(int id);

    List<Student> getByGroupId(int id);

    Student save(Student student);

    Student save(StudentInfo studentInfo);

    void delete(int id);

    Student saveWithoutPassword(StudentInfo studentInfo);

    void savePassword(StudentInfo studentInfo);
}
