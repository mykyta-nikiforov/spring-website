package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    void save(Teacher teacher);
}
