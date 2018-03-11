package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.model.TeacherInfo;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher getById(int id);

    void save(Teacher teacher);

    void save(TeacherInfo teacherInfo);

    void delete(int id);
}
