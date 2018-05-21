package io.nikiforov.edu.model;


public class GroupInfo {
    private int groupId;
    private String number;
    private int specialtyId;
    private int yearOfStudy;
    private int curatorId;

    public GroupInfo() {
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    @Override
    public String toString() {
        return "GroupInfo{" +
                "groupId=" + groupId +
                ", number='" + number + '\'' +
                ", specialtyId=" + specialtyId +
                ", yearOfStudy=" + yearOfStudy +
                ", curatorId=" + curatorId +
                '}';
    }
}