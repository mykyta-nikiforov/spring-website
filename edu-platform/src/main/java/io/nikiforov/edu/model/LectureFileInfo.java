package io.nikiforov.edu.model;

public class LectureFileInfo {
    private int lectureId;
    private String name;

    public LectureFileInfo() {
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
