package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.Group;
import io.nikiforov.edu.model.GroupInfo;
import java.util.List;

public interface GroupService {
    List<Group> findAll();

    Group getGroup(int id);

    Group save(Group group);

    Group save(GroupInfo groupInfo);

    Group update(GroupInfo groupInfo);

    void delete(int id);
}
