package io.nikiforov.edu.entity;

import javax.persistence.*;

import io.nikiforov.edu.entity.Course;

@Entity
public class Lecture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

	public Lecture() {
	}
	
	public Lecture(int id, String name, int courseId) {
		super();
		this.id = id;
		this.name = name;
		this.course = new Course(courseId, "", "");
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

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
