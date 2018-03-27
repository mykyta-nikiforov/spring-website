package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.LecturePDFFileRepository;
import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.entity.LecturePDFFile;
import io.nikiforov.edu.model.LecturePDFFileInfo;
import io.nikiforov.edu.service.LectureFileService;
import io.nikiforov.edu.service.LecturePDFFileService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturePDFFileServiceImpl implements LecturePDFFileService {

    @Autowired
    LecturePDFFileRepository lecturePDFFileRepository;

    @Autowired
    LectureFileService lectureFileService;

    @Autowired
    LectureService lectureService;


    @Override
    public LecturePDFFile save(LecturePDFFileInfo lecturePDFFileInfo) {
        System.out.println("Hello from LecturePDF service");
        int lectureId = lecturePDFFileInfo.getLectureId();
        LecturePDFFile result;
        if(findOne(lectureId) != null){
            result = findOne(lectureId);
        } else{
            result = new LecturePDFFile();
            Lecture lecture = lectureService.getLecture(lectureId);
            result.setLecture(lecture);
        }

        System.out.println("1");

        result.setLectureFile(lectureFileService.findById(lecturePDFFileInfo.getLectureFileId()));

        System.out.println("2");
        result = lecturePDFFileRepository.save(result); // To get back saved LecturePDFFile with "id"

        System.out.println("3");
        return result;
    }

    @Override
    public LecturePDFFile findOne(int id) {
        return lecturePDFFileRepository.findOne(id);
    }
}
