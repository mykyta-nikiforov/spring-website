package io.nikiforov.edu.model;

public class LectureInfo {
    private String name;
    private int courseId;

    public LectureInfo() {
    }

    public LectureInfo(String name, int courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", courseId=" + courseId +
                '}';
    }
}
