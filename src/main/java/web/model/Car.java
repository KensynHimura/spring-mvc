package web.model;

import org.springframework.stereotype.Controller;


public class Car {
    private String color;
    private boolean engine;
    private int wheels;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (engine != car.engine) return false;
        if (wheels != car.wheels) return false;
        return color != null ? color.equals(car.color) : car.color == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (engine ? 1 : 0);
        result = 31 * result + wheels;
        return result;
    }

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
