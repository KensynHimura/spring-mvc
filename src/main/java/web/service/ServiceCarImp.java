package web.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServiceCarImp implements ServiceCar {

    public List<Car> allCars() {
    List<Car> cars = new ArrayList<>();
        cars.add(new Car("red", true, 4));
        cars.add(new Car("white", false, 16));
        cars.add(new Car("black", false, 4));
        cars.add(new Car("red", false, 3));
        cars.add(new Car("green", true, 4));
        return cars;
    }

    @Override
    public List<Car> getCars(int value) {
        return allCars().stream().limit(value).collect(Collectors.toList());
    }
}