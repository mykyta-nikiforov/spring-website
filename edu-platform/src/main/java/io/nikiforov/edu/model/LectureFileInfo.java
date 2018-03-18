package io.nikiforov.edu.model;

public class LectureFileInfo {
    private int lectureId;
    private String description;

    public LectureFileInfo() {
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
