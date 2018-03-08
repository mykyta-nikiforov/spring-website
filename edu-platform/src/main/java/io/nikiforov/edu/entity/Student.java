package io.nikiforov.edu.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@Proxy(lazy = false)
public class Student extends User{

    private String name;
    private String surname;
    private String patronymic;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student() {
    }

    public Student(Student modelStudent) {
        super(modelStudent.getEmail(), modelStudent.getPassword(),
                modelStudent.getRoles());
        this.name = modelStudent.name;
        this.surname = modelStudent.surname;
        this.patronymic = modelStudent.patronymic;
        this.group = modelStudent.group;
    }

    public Student(String name, String surname, String patronymic, Group group) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.group = group;
    }

    public Student(String username, String password, Set<Role> roles) {
        super(username, password, roles);
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
