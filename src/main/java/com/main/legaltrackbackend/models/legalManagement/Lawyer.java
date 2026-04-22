package com.main.legaltrackbackend.models.legalManagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.main.legaltrackbackend.models.auth.User;
import com.main.legaltrackbackend.models.clientsManagement.Client;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String barAssociationNumber;

    @Column
    private String specialization;

    @OneToOne(mappedBy = "lawyer")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "lawyer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Client> clients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonBackReference
    private User admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBarAssociationNumber() {
        return barAssociationNumber;
    }

    public void setBarAssociationNumber(String barAssociationNumber) {
        this.barAssociationNumber = barAssociationNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", barAssociationNumber='" + barAssociationNumber + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
