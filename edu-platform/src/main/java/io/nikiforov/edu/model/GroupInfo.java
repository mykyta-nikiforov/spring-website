package io.nikiforov.edu.model;

import io.nikiforov.edu.entity.Teacher;

public class GroupInfo {
    private String number;
    private Teacher curator;

    public GroupInfo() {
    }

    public GroupInfo(String number, Teacher curator) {
        this.number = number;
        this.curator = curator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }
}
