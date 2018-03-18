package io.nikiforov.edu.entity;

import io.nikiforov.edu.model.LectureFileInfo;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class LectureFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fileName;
    private String description;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;
    private String contentType;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public LectureFile() {
    }

    public LectureFile(LectureFileInfo lectureFileInfo) {
        this.description = lectureFileInfo.getDescription();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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
                ", contentType='" + contentType + '\'' +
                ", lecture=" + lecture +
                '}';
    }
}
