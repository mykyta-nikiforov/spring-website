package io.nikiforov.edu.entity;

import io.nikiforov.edu.model.StudentInfo;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Proxy(lazy = false)
public class Student extends User{
    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student() {
    }

    public Student(StudentInfo studentInfo) {
        this.email = studentInfo.getEmail();
        this.password = studentInfo.getPassword();
        this.name = studentInfo.getName();
        this.surname = studentInfo.getSurname();
        this.patronymic = studentInfo.getPatronymic();
        this.group = studentInfo.getGroup();
    }

    public Student(String email, String password, boolean enabled,
                   boolean accountNonExpired, boolean credentialsNonExpired,
                   boolean accountNonLocked, Set<Role> roles) {
        super(email, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, roles);
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", group=" + group +
                '}';
    }
}