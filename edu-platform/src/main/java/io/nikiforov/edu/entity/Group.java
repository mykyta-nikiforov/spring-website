package io.nikiforov.edu.entity;

import io.nikiforov.edu.model.GroupInfo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Groupp")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column(unique = true)
    private String number;
    @NotNull
    private int yearOfStudy;
    @NotNull
    @OneToOne
    @JoinColumn(name = "curator_id", unique = true)
    private Teacher curator;
    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    public Group() {
        yearOfStudy = 1;
    }

    public Group(String number, int yearOfStudy, Teacher curator, Set<Student> students) {
        this.number = number;
        this.yearOfStudy = yearOfStudy;
        this.curator = curator;
        this.students = students;
    }

    public Group(GroupInfo groupInfo) {
        this.number = groupInfo.getNumber();
        this.yearOfStudy = groupInfo.getYearOfStudy();
        this.curator = groupInfo.getCurator();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", curator=" + curator +
                '}';
    }
}
