package io.nikiforov.edu.model;

public class LectureInfo {
    private String name;
    private String description;
    private int courseId;

    public LectureInfo() {
    }

    public LectureInfo(String name, String description, int courseId) {
        this.name = name;
        this.description = description;
        this.courseId = courseId;
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

    @Override
    public String toString() {
        return "LectureInfo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
