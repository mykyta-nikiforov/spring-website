package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.model.TeacherInfo;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher getById(int id);

    Teacher save(Teacher teacher);

    Teacher save(TeacherInfo teacherInfo);

    Teacher saveWithoutPassword(TeacherInfo teacherInfo);

    void savePassword(TeacherInfo teacherInfo);

    void delete(int id);

    List<Teacher> findFreeCurators();

    Teacher save(UserDetails userDetails, TeacherInfo teacherInfo);

    void savePassword(UserDetails userDetails, TeacherInfo teacherInfo);
}
