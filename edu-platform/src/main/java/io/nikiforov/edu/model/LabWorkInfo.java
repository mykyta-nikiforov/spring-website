package io.nikiforov.edu.model;

import io.nikiforov.edu.entity.LabWork;

import java.time.LocalDate;

public class LabWorkInfo {

    private int id;
    private String name;
    private String description;
    private int courseId;
    private LocalDate deadLine;

    public LabWorkInfo() {
    }

    public LabWorkInfo(LabWork labWork) {
        id = labWork.getId();
        name = labWork.getName();
        description = labWork.getDescription();
        deadLine = labWork.getDeadLine();
        courseId = labWork.getCourse().getId();
    }

    public static LabWorkInfo newInstanceWithCourseId(int id) {
        LabWorkInfo labWorkInfo = new LabWorkInfo();
        labWorkInfo.setCourseId(id);
        return labWorkInfo;
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "LabWorkInfo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
