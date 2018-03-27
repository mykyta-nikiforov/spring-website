package io.nikiforov.edu.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.nikiforov.edu.entity.Course;
import io.nikiforov.edu.model.LectureInfo;
import javassist.expr.Cast;

import java.util.List;

@Entity
public class Lecture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecture")
    private List<LectureFile> lectureFiles;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    LecturePDFFile lecturePDFFile;

	public Lecture() {
	}
	
	public Lecture(int id, String name, int courseId) {
		super();
		this.id = id;
		this.name = name;
		this.course = new Course(courseId, "", "");
	}

    public Lecture(LectureInfo lectureInfo) {
        name = lectureInfo.getName();
    }

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

    public List<LectureFile> getLectureFiles() {
        return lectureFiles;
    }

    public void setLectureFiles(List<LectureFile> lectureFiles) {
        this.lectureFiles = lectureFiles;
    }

    public LecturePDFFile getLecturePDFFile() {
        return lecturePDFFile;
    }

    public void setLecturePDFFile(LecturePDFFile lecturePDFFile) {
        this.lecturePDFFile = lecturePDFFile;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", lecturePDFFile=" + lecturePDFFile +
                '}';
    }
}
