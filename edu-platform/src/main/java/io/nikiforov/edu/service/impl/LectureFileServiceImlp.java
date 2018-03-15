package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.LectureFileRepository;
import io.nikiforov.edu.entity.LectureFile;
import io.nikiforov.edu.service.LectureFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureFileServiceImlp implements LectureFileService {

    @Autowired
    LectureFileRepository lectureFileRepository;

    @Override
    public void save(LectureFile lectureFile) {
        lectureFileRepository.save(lectureFile);
    }
}
