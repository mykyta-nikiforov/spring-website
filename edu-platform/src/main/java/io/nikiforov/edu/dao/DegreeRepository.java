package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
}
