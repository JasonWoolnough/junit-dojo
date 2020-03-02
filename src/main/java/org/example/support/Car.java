package org.example.support;

import lombok.Data;

@Data
public class Car {
    private String make;
    private String model;
    private String colour;

    public Car(CarDto carDto) {
        this.make = carDto.getMake();
        this.model = carDto.getModel();
        this.model = carDto.getColour();
    }

    public CarDto toCarDto() {
        CarDto carDto = new CarDto();
        carDto.setColour(this.colour);
        carDto.setModel(this.model);
        carDto.setMake(this.make);
        return carDto;
    }
}
