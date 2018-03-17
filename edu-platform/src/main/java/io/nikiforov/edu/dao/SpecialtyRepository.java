package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>{
}
