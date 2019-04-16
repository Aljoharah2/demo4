package com.example.demo4.Models;

public class Production_companies {
    private String name;
    private int id;
    private String origin_country;

    public Production_companies(String name, int id, String origin_country) {
        this.name = name;
        this.id = id;
        this.origin_country = origin_country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    @Override
    public String toString() {
        return "Production_companies{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", origin_country='" + origin_country + '\'' +
                '}';
    }
}
