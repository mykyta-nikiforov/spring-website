package io.nikiforov.edu.dao;

import io.nikiforov.edu.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer>{
    Role findByRole(String role);
}
