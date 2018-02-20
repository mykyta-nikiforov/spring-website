package io.nikiforov.edu.service;

import java.util.ArrayList;
import java.util.List;

import io.nikiforov.edu.dao.LectureRepository;
import io.nikiforov.edu.entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
	
	@Autowired
	private LectureRepository lectureRepository;
	
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
}