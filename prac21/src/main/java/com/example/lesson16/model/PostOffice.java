package com.example.lesson16.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "postoffice")
public class PostOffice implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<Departure> departures;

    public PostOffice() {
    }

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Departure> getItems() {
        return departures;
    }

    public void setItems(List<Departure> phones) {
        this.departures = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostOffice postOffice = (PostOffice) o;
        return Objects.equals(name, postOffice.name) && Objects.equals(cityName, postOffice.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cityName, departures);
    }
}
