package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.LabWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabWorkRepository extends JpaRepository<LabWork, Integer> {
    List<LabWork> findAllByCourseId(int id);
}
