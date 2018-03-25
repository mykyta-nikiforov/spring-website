package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.LectureFileRepository;
import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.entity.LectureFile;
import io.nikiforov.edu.model.LectureFileInfo;
import io.nikiforov.edu.service.LectureFileService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class LectureFileServiceImlp implements LectureFileService {

    @Autowired
    LectureFileRepository lectureFileRepository;

    @Autowired
    LectureService lectureService;

    @Override
    public void save(LectureFile lectureFile) {
        lectureFileRepository.save(lectureFile);
    }

    @Override
    public List<LectureFile> findAllByLectureId(int id) {
        return lectureFileRepository.findAllByLectureId(id);
    }

    @Override
    public LectureFile findById(int id) {
        return lectureFileRepository.getOne(id);
    }

    @Override
    public LectureFile save(LectureFileInfo lectureFileInfo, MultipartFile file)
            throws IOException {
        System.out.println("Hello from save()");
        Lecture lecture = lectureService.getLecture(lectureFileInfo.getLectureId());
        LectureFile lectureFile = new LectureFile(lectureFileInfo);
        lectureFile.setLecture(lecture);
        lectureFile.setFileName(file.getOriginalFilename());
        lectureFile.setContentType(file.getContentType());
        lectureFile.setData(file.getBytes());
        return lectureFileRepository.save(lectureFile);
    }

    @Override
    public void delete(int id) {
        lectureFileRepository.delete(id);
    }
}