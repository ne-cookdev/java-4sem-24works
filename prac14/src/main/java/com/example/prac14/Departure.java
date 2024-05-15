package com.example.prac14;

import java.util.Objects;

public class Departure {
    private String type;
    private int departureDate;

    public Departure() {
    }

    public Departure(String type, int departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(int departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departure departure = (Departure) o;
        return Objects.equals(type, departure.type) && Objects.equals(departureDate, departure.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, departureDate);
    }
}
