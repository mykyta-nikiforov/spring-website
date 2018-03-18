package io.nikiforov.edu.service;

import io.nikiforov.edu.entity.LectureFile;
import io.nikiforov.edu.model.LectureFileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LectureFileService {
    List<LectureFile> findAllByLectureId(int id);

    LectureFile getById(int id);

    void save(LectureFile lectureFile);

    void save(LectureFileInfo lectureFileInfo, MultipartFile file, int id) throws IOException;

    void delete(int id);
}
