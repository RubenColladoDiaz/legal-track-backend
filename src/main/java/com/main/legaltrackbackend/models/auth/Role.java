package com.main.legaltrackbackend.models.auth;

import com.main.legaltrackbackend.enums.RoleName;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleName name;

    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();

    public Role() {
        super();
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {}

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
    }
}
