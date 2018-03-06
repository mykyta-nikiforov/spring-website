package io.nikiforov.edu.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Groupp")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String number;
    private int yearOfStudy;
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
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
                "number='" + number + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", curator=" + curator +
                ", students=" + students +
                '}';
    }
}
