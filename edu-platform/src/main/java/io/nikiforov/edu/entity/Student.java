package io.nikiforov.edu.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import java.util.Set;

@Entity
@Proxy(lazy = false)
public class Student extends User{

    private String name;
    private String surname;
    private String group;

    public Student() {
    }

    public Student(String username, String password, Set<Role> roles) {
        super(username, password, roles);
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
