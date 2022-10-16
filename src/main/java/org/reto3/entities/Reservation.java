package org.reto3.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer idReservation;

    @Column(name = "startDate")
    private  Date startDate;

    @Column(name = "devolutionDate")
    private  Date devolutionDate;

    @Column(name = "status")
    private  String status;

    @Column(name = "farm")
    private  Farm farm;

    @Column(name = "client")
    private  Farm client;

    //Constructor No-args
    public Reservation() {
    }

    //Constructor

    public Reservation(Integer idReservation, Date startDate, Date devolutionDate, String status, Farm farm, Farm client) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.farm = farm;
        this.client = client;
    }


    //Getters and Setters


    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Farm getClient() {
        return client;
    }

    public void setClient(Farm client) {
        this.client = client;
    }
}
