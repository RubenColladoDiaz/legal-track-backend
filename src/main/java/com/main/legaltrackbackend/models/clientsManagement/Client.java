package com.main.legaltrackbackend.models.clientsManagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.main.legaltrackbackend.models.legalManagement.Lawyer;
import jakarta.persistence.*;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private int phone;

    @Column
    private String address;

    @Column(unique = true)
    private String dni;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    @JsonBackReference
    private Lawyer lawyer;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", phone=" + phone + ", address=" + address + ", dni=" + dni + "]";
    }
}
