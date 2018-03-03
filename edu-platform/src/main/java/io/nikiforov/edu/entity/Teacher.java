package io.nikiforov.edu.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Proxy(lazy = false)
//@PrimaryKeyJoinColumn(name="id")
public class Teacher extends User{
    private String name;
    private String surname;
    // e.g. "Professor", "PhD", "Docent"
    private String degree;

    public Teacher() {
    }

    public Teacher(String name, String surname, String degree) {
        this.name = name;
        this.surname = surname;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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
