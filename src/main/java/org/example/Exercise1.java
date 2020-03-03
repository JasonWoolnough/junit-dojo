package org.example;

import org.example.support.Car;
import org.example.support.CarAdapter;
import org.example.support.CarDto;

public class Exercise1 {
    private final CarAdapter carAdapter;

    public Exercise1(CarAdapter carAdapter) {
        this.carAdapter = carAdapter;
    }

    public Car saveCar(Car car) {
        CarDto carDto = carAdapter.save(new CarDto());
        return new Car(carDto);
    }
}
