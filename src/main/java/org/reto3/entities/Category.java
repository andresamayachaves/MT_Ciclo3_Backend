package org.reto3.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "farm")
public class Category implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "farms")
    private Farm[] farms;

    //Constructor No-args
    public Category() {
    }

    //Constructor
    public Category(Integer id, String name, Farm[] farms) {
        this.id = id;
        this.name = name;
        this.farms = farms;
    }


    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Farm[] getFarms() {
        return farms;
    }

    public void setFarms(Farm[] farms) {
        this.farms = farms;
    }
}

