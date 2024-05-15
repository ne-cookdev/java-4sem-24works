package com.example.prac14;

import java.util.Objects;

public class PostOffice {
    private String name;
    private String cityName;

    public PostOffice() {
    }

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostOffice postOffice = (PostOffice) o;
        return Objects.equals(name, postOffice.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
