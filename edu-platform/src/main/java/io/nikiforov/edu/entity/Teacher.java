package io.nikiforov.edu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.nikiforov.edu.model.TeacherInfo;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Proxy(lazy = false)
public class Teacher extends User{
    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String patronymic;

    // e.g. "Professor", "PhD", "Docent"
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @JsonIgnore
    @OneToOne(mappedBy = "curator", fetch = FetchType.LAZY)
    private Group curatedGroup;

    public Teacher() {
    }

    public Teacher(TeacherInfo teacherInfo, Degree degree) {
        this.email = teacherInfo.getEmail();
        this.password = teacherInfo.getPassword();
        this.name = teacherInfo.getName();
        this.surname = teacherInfo.getSurname();
        this.patronymic = teacherInfo.getPatronymic();
        this.degree = degree;
    }

    public Teacher(String name, String surname, String patronymic, Degree degree) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.degree = degree;
    }

    public Teacher(String email, String password, boolean enabled,
                   boolean accountNonExpired, boolean credentialsNonExpired,
                   boolean accountNonLocked, Set<Role> roles) {
        super(email, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, roles);
    }

    public Teacher(String username, String password, Set<Role> roles) {
        super(username, password, roles);
    }

    // When delete curator, set curator_id in Group to null
    @PreRemove
    public void preRemove() {
        if(curatedGroup!=null)
            curatedGroup.setCurator(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Group getCuratedGroup() {
        return curatedGroup;
    }

    public void setCuratedGroup(Group curatedGroup) {
        this.curatedGroup = curatedGroup;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}