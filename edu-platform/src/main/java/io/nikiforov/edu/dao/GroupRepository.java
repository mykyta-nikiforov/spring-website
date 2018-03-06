package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer>{
}
