package io.nikiforov.edu.model;

public class LecturePDFFileInfo {
    private int lectureFileId;
    private int lectureId;

    public LecturePDFFileInfo() {
    }

    public LecturePDFFileInfo(int lectureFileId, int lectureId) {
        this.lectureFileId = lectureFileId;
        this.lectureId = lectureId;
    }

    public int getLectureFileId() {
        return lectureFileId;
    }

    public void setLectureFileId(int lectureFileId) {
        this.lectureFileId = lectureFileId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    @Override
    public String toString() {
        return "LecturePDFFileInfo{" +
                "lectureFileId=" + lectureFileId +
                ", lectureId=" + lectureId +
                '}';
    }
}