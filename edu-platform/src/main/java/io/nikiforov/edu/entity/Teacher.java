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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degree_id")
    private Degree degree;
    @OneToOne(mappedBy = "curator", fetch = FetchType.LAZY)
    private Group curatedGroup;

    public Teacher() {
    }

    public Teacher(String name, String surname, Degree degree) {
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
