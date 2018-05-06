package io.nikiforov.edu.entity;

import io.nikiforov.edu.model.LabWorkFileInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.Arrays;

@Entity
public class LabWorkFile {
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
    @JoinColumn(name = "labwork_id")
    private LabWork labWork;

    public LabWorkFile() {
    }

    public LabWorkFile(LabWorkFileInfo labWorkFileInfo, MultipartFile file) {
        fileName = file.getOriginalFilename();
        description = labWorkFileInfo.getDescription();
        try {
            data = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentType = file.getContentType();

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

    public LabWork getLabWork() {
        return labWork;
    }

    public void setLabWork(LabWork labWork) {
        this.labWork = labWork;
    }

    @Override
    public String toString() {
        return "LabWorkFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", data=" + Arrays.toString(data) +
                ", contentType='" + contentType + '\'' +
                ", labWork=" + labWork +
                '}';
    }
}
