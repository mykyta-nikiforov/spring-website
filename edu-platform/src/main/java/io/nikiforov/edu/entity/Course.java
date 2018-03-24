package io.nikiforov.edu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.nikiforov.edu.model.CourseInfo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Column(length = 1000)
	private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Lecture> lectures;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<LabWork> labWorks;

//    private Teacher lecturer;
//	private Teacher labAssistant;

	public Course() {
	}

    public Course(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

    public Course(CourseInfo courseInfo) {
        name = courseInfo.getName();
        description = courseInfo.getDescription();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public List<LabWork> getLabWorks() {
        return labWorks;
    }

    public void setLabWorks(List<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}