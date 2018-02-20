package io.nikiforov.edu.service;

import java.util.List;
import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.model.LectureInfo;

public interface LectureService {

    List<Lecture> getAllLectures(int id);
    Lecture getLecture(int id);
    void addLecture(Lecture lecture);
    void updateLecture(Lecture lecture);
    void deleteLecture(int id);
    void saveLectureFromModel(LectureInfo lectureInfo);
}