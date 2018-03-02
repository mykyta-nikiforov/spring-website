package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}

