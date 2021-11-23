package web.model;

import org.springframework.stereotype.Controller;


public class Car {
    private String color;
    private boolean engine;
    private int wheels;

    public Car() {
    }

    public Car(String color, boolean isHybridEngine, int wheels) {
        this.color = color;
        this.engine = isHybridEngine;
        this.wheels = wheels;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", engine=" + engine +
                ", wheels=" + wheels +
                '}';
    }
}
