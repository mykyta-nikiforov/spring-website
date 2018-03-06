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
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Student() {
    }

    public Student(String name, String surname, Group group) {
        this.name = name;
        this.surname = surname;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
