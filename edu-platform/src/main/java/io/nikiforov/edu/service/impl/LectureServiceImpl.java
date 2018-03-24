package io.nikiforov.edu.service.impl;

import io.nikiforov.edu.dao.LectureRepository;
import io.nikiforov.edu.entity.Lecture;
import io.nikiforov.edu.model.LectureInfo;
import io.nikiforov.edu.service.CourseService;
import io.nikiforov.edu.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private CourseService courseService;

    public List<Lecture> getAllLectures(int id) {
        List<Lecture> courses = new ArrayList<>();
        lectureRepository.findByCourseId(id)
                .forEach(courses::add);
        return courses;
    }

    public Lecture getLecture(int id) {
        return lectureRepository.findOne(id);
    }

    public void addLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    public void updateLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    public void deleteLecture(int id) {
        lectureRepository.delete(id);
    }

    public void saveLectureFromModel(LectureInfo lectureInfo){
        Lecture lecture = new Lecture();
        lecture.setName(lectureInfo.getName());
        lecture.setCourse(courseService.getCourse(lectureInfo.getCourseId()));
        lectureRepository.save(lecture);
    }

    @Override
    public Lecture addLecture(LectureInfo lectureInfo) {
        // Convert LectureInfo to Lecture
        Lecture result = new Lecture(lectureInfo);
        // Set Course based on "courseId"  from lectureInfo
        result.setCourse(courseService.getCourse(lectureInfo.getCourseId()));
        // Save it, get back saved result from database (with set ID) and return it
        result = lectureRepository.save(result);
        return result;
    }
}
