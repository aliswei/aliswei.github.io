package com.asswei.demo.enitity;

public class Sensor {
    private String id;
    private double temp;

    public Sensor(String id, double temp) {
        this.id = id;
        this.temp = temp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
