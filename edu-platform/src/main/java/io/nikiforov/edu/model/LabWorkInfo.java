package io.nikiforov.edu.model;

public class LabWorkInfo {

    private String name;
    private String description;
    private int courseId;

    public LabWorkInfo() {
    }

    public static LabWorkInfo newInstanceWithCourseId(int id) {
        LabWorkInfo labWorkInfo = new LabWorkInfo();
        labWorkInfo.setCourseId(id);
        return labWorkInfo;
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
        return "LabWorkInfo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
