package io.nikiforov.edu.model;

import io.nikiforov.edu.entity.LabWork;
import java.time.format.DateTimeFormatter;

public class LabWorkInfo {
    private int id;
    private String name;
    private String description;
    private String deadLine;
    private int courseId;

    public LabWorkInfo() {
    }

    public LabWorkInfo(LabWork labWork) {
        id = labWork.getId();
        name = labWork.getName();
        description = labWork.getDescription();
        System.out.println("from LabWorkInfo constructor: " + labWork);
        deadLine = labWork.getDeadLine().format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        System.out.println("from LabWorkInfo constructor: " + deadLine);
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

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "LabWorkInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}