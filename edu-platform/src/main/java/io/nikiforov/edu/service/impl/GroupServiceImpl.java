package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.*;
import io.nikiforov.edu.entity.Group;
import io.nikiforov.edu.entity.Specialty;
import io.nikiforov.edu.entity.Teacher;
import io.nikiforov.edu.model.GroupInfo;
import io.nikiforov.edu.service.GroupService;
import io.nikiforov.edu.service.SpecialtyService;
import io.nikiforov.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SpecialtyService specialtyService;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroup(int id) {
        return groupRepository.findOne(id);
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    // Get values from GroupInfo and save
    @Override
    public Group save(GroupInfo groupInfo) {
        Teacher curator = teacherService.getById(groupInfo.getCuratorId());
        Specialty specialty = specialtyService.getById(groupInfo.getSpecialtyId());
        Group group = new Group(groupInfo, specialty, curator);
        return save(group);
    }

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
    public Group update(GroupInfo groupInfo) {
        Teacher newCurator = teacherRepository.findOne(groupInfo.getCuratorId());
        Group result = getGroup(groupInfo.getGroupId());
        result.setNumber(groupInfo.getNumber());
        result.setCurator(newCurator);

        // If curator had a group, set curator of this group to null
        // The second check is to sure that previousGroup is not current
        Group previousGroupOfTeacher = newCurator.getCuratedGroup();
        if (previousGroupOfTeacher != null && previousGroupOfTeacher.getId() != groupInfo.getGroupId()) {
            previousGroupOfTeacher.setCurator(null);
            groupRepository.save(previousGroupOfTeacher);
        }
        return save(result);
    }

    @Override
    public void delete(int id) {
        groupRepository.delete(id);
    }
}