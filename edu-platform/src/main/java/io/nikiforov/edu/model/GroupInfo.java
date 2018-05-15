package io.nikiforov.edu.model;

import io.nikiforov.edu.entity.*;

public class GroupInfo {
    private String number;
    private int specialtyId;
    private int yearOfStudy;
    private int curatorId;

    public GroupInfo() {
    }

    public GroupInfo(String number, int curatorId) {
        this.number = number;
        this.curatorId = curatorId;
    }

    public GroupInfo(String number, int specialtyId, int yearOfStudy, int curatorId) {
        this.number = number;
        this.specialtyId = specialtyId;
        this.yearOfStudy = yearOfStudy;
        this.curatorId = curatorId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(int curatorId) {
        this.curatorId = curatorId;
    }
}