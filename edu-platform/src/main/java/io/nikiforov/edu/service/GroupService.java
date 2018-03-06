package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    void save(Group group);
}
