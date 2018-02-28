package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.RoleRepository;
import io.nikiforov.edu.entity.Role;
import io.nikiforov.edu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRole(String role) {
        return roleRepository.findByRole(role);
    }
}
