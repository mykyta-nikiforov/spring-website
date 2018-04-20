package io.nikiforov.edu.model;

public class LabWorkFileInfo {
    private int labWorkId;
    private String description;

    public LabWorkFileInfo() {
    }

    public LabWorkFileInfo(int labWorkId, String description) {
        this.labWorkId = labWorkId;
        this.description = description;
    }

    public int getLabWorkId() {
        return labWorkId;
    }

    public void setLabWorkId(int labWorkId) {
        this.labWorkId = labWorkId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
