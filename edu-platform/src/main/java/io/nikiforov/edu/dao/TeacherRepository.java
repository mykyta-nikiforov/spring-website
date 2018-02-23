package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
