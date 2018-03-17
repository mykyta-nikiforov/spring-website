package io.nikiforov.edu.model;

import io.nikiforov.edu.entity.Group;
import io.nikiforov.edu.entity.Specialty;
import io.nikiforov.edu.entity.Teacher;

public class GroupInfo {
    private String number;
    private Specialty specialty;
    private int yearOfStudy;
    private Teacher curator;

    public GroupInfo() {
    }

    public GroupInfo(String number, Teacher curator) {
        this.number = number;
        this.curator = curator;
    }

    public GroupInfo(String number, Specialty specialty, int yearOfStudy, Teacher curator) {
        this.number = number;
        this.specialty = specialty;
        this.yearOfStudy = yearOfStudy;
        this.curator = curator;
    }

    public GroupInfo(Group group) {
        this.number = group.getNumber();
        this.yearOfStudy = group.getYearOfStudy();
        this.curator = group.getCurator();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }
}