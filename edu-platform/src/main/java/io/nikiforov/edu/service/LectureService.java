package io.nikiforov.edu.service;

import java.util.List;
import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.model.LectureInfo;

public interface LectureService {
    List<Lecture> getAllLectures(int id);

    Lecture getLecture(int id);

    void addLecture(Lecture lecture);

    Lecture updateLecture(Lecture lecture);

    Lecture updateLecture(LectureInfo lectureInfo);

    void deleteLecture(int id);

    void saveLectureFromModel(LectureInfo lectureInfo);

    Lecture addLecture(LectureInfo lectureInfo);
}