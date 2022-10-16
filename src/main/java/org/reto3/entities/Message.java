package org.reto3.entities;

import org.reto3.services.ClientService;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer idMessage;

    @Column(name = "farm")
    private  Farm farm;

    @Column(name = "messageText")
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "client_id_client")
    private Client  client;

    @Column(name = "client")
    private Integer clientId;


    public Integer getClient() {
        return client.getIdClient();
    }

    public void setClient(Client client) {
        this.clientId = client.getIdClient();
    }

    //Constructor No-args
    public Message() {
    }

    //Constructor
    public Message(Integer idMessage, Farm farm, String messageText) {
        this.idMessage = idMessage;
        this.farm = farm;
        this.messageText = messageText;
    }


    //Getters and setters

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
