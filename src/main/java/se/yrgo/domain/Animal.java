package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(name = "M_ID")
    private int microshipID;
    private String species;
    @Column(name = "DATE_OF_BIRTH")
    private int dateOfBirth;
    @Transient
    private boolean isHealthy;

    public Animal() {
    }

    public Animal(String name, int microshipID, String species) {
        this.name = name;
        this.microshipID = microshipID;
        this.species = species;
    }

    public Animal(String name, int microshipID, String species, int dateOfBirth) {
        this.name = name;
        this.microshipID = microshipID;
        this.species = species;
        this.dateOfBirth = dateOfBirth;
    }

    public Animal(String name, int microshipID, String species, int dateOfBirth, boolean isHealthy) {
        this.name = name;
        this.microshipID = microshipID;
        this.species = species;
        this.dateOfBirth = dateOfBirth;
        this.isHealthy = isHealthy;
    }
    public String getName() {
        return name;
    }

    public int getMicroshipID() {
        return microshipID;
    }

    public String getSpecies() {
        return species;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", id: " + microshipID;
    }
}
