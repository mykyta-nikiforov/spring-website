package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.LectureFile;

public interface LectureFileService {
    void save(LectureFile lectureFile);

    LectureFile getById(int id);
}
