package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.LabWorkRepository;
import io.nikiforov.edu.entity.LabWork;
import io.nikiforov.edu.model.LabWorkInfo;
import io.nikiforov.edu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LabWorkServiceImpl implements LabWorkService {

    @Autowired
    LabWorkRepository labWorkRepository;

    @Autowired
    CourseService courseService;

    @Override
    public List<LabWork> findAllByCourseId(int id) {
        return labWorkRepository.findAllByCourseId(id);
    }

    @Override
    public LabWork getLabWork(int id) {
        return labWorkRepository.findOne(id);
    }

    @Override
    public void addLabWork(LabWork labWork) {
        labWorkRepository.save(labWork);
    }

    @Override
    public void updateLabWork(LabWork labWork) {
        labWorkRepository.save(labWork);
    }

    @Override
    public void deleteLabWork(int id) {
        labWorkRepository.delete(id);
    }

    @Override
    public LabWork saveFromModel(LabWorkInfo labWorkInfo) {
        LabWork labWork = new LabWork(labWorkInfo);
        labWork.setCourse(courseService.getCourse(labWorkInfo.getCourseId()));
        return labWorkRepository.save(labWork);
    }
}