package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.LabWork;
import io.nikiforov.edu.model.LabWorkInfo;

import java.util.List;

public interface LabWorkService {
    List<LabWork> findAllByCourseId(int id);

    LabWork getLabWork(int id);

    void addLabWork(LabWork labWork);

    void updateLabWork(LabWork labWork);

    void deleteLabWork(int id);

    LabWork saveFromModel(LabWorkInfo labWorkInfo);
}