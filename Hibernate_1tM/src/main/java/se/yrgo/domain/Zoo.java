package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    @Column(name = "SINCE_YEAR")
    private int openedYear;
    @OneToMany
    @JoinColumn(name = "ZOO_FK")
    private List<Animal> zooAnimals;

    public Zoo() {
    }

    public Zoo(String name, String address) {
        this.name = name;
        this.address = address;
        this.zooAnimals = new ArrayList<>(3);
    }

    public Zoo(String name, String address, int openedYear) {
        this.name = name;
        this.address = address;
        this.openedYear = openedYear;
        this.zooAnimals = new ArrayList<>(3);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getOpenedYear() {
        return openedYear;
    }

    public void addAnimalToZoo(Animal animal) {
        this.zooAnimals.add(animal);
    }

    public List<Animal> getZooAnimals() {
        List<Animal> unmodifiable =
                Collections.unmodifiableList(this.zooAnimals);
        return unmodifiable;
    }
}
