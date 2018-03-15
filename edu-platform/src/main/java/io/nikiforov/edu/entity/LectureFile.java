package io.nikiforov.edu.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class LectureFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fileName;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public LectureFile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @Override
    public String toString() {
        return "LectureFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", data=" + Arrays.toString(data) +
                ", lectureId=" + lecture.getId() +
                '}';
    }
}
