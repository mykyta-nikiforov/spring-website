package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.*;
import io.nikiforov.edu.entity.Group;
import io.nikiforov.edu.model.GroupInfo;
import io.nikiforov.edu.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroup(int id) {
        return groupRepository.findOne(id);
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    // Transform from GroupInfo to Group and save
    @Override
    public void save(GroupInfo groupInfo) {
        Group group = new Group(groupInfo);
        save(group);
    }

    @Override
    public void update(Group group) {
        Group previousGroupOfTeacher = teacherRepository
                .findOne(group.getCurator().getId())
                .getCuratedGroup();
        if (previousGroupOfTeacher != null) {
            previousGroupOfTeacher.setCurator(null);
            groupRepository.save(previousGroupOfTeacher);
        }
        groupRepository.save(group);
    }

    @Override
    public void delete(int id) {
        groupRepository.delete(id);
    }
}