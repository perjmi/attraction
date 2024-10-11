package com.example.attraction;

public class Tattraction {
    private String name;
    private String desc;
    private City place;

    public Tattraction(String name, String desc, City place) {
        this.name = name;
        this.desc = desc;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public City getPlace() {
        return place;
    }

    public void setPlace(City place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Tattraction{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", place=" + place +
                '}';
    }
}
