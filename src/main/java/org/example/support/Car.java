package org.example.support;

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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
