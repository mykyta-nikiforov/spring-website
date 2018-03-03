package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
