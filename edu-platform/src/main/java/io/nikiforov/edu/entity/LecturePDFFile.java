package io.nikiforov.edu.entity;

import javax.persistence.*;

@Entity
public class LecturePDFFile {

    @Id
    private int id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Lecture lecture;

    @OneToOne
    private LectureFile lectureFile;

    public LecturePDFFile() {
    }

    public LecturePDFFile(int id, Lecture lecture, LectureFile lectureFile) {
        this.id = id;
        this.lecture = lecture;
        this.lectureFile = lectureFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public LectureFile getLectureFile() {
        return lectureFile;
    }

    public void setLectureFile(LectureFile lectureFile) {
        this.lectureFile = lectureFile;
    }

    @Override
    public String toString() {
        return "LecturePDFFile{" +
                "id=" + id +
                ", lectureFileId=" + lectureFile.getId() +
                '}';
    }
}
