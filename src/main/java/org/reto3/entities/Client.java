package org.reto3.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idClient;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "messages")
    private Message[] messages;

    @Column(name = "reservations")
    private Reservation[] reservations;

    //Constructor No-args
    public Client() {
    }

    //Constructor
    public Client(Integer idClient, String email, String password, String name, Integer age, Message[] messages, Reservation[] reservations) {
        this.idClient = idClient;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.messages = messages;
        this.reservations = reservations;
    }

    //Getters and Setters

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public Reservation[] getReservations() {
        return reservations;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }
}
