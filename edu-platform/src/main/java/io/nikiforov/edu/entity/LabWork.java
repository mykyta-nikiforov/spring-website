package io.nikiforov.edu.entity;

import io.nikiforov.edu.model.LabWorkInfo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class LabWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column
    private LocalDate deadLine;

    public LabWork() {
    }

    public LabWork(LabWorkInfo labWorkInfo) {
        this.id = labWorkInfo.getId();
        this.name = labWorkInfo.getName();
        this.description = labWorkInfo.getDescription();
        this.deadLine = labWorkInfo.getDeadLine();
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", course=" + course +
                ", deadLine=" + deadLine +
                '}';
    }
}
