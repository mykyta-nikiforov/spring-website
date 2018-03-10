package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Group;
import io.nikiforov.edu.model.GroupInfo;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    Group getGroup(int id);

    void save(Group group);

    void save(GroupInfo groupInfo);

    void update(Group group);
}
