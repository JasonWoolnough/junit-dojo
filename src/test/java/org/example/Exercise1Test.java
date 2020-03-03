package org.example;

import org.example.support.Car;
import org.example.support.CarAdapter;
import org.example.support.CarDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * This class can be fully tested using only one method.
 * <p>
 * You're going to need:
 * 1. An argument captor (to ensure car adapter saves the correct thing)
 * 2. A when-then declaration to mock carAdapter.save's behaviour
 * 3. 2 asserts. One for the captured argument provided to carAdapter.save, and one for the tested method's return object.
 *
 * Hint: When we use assertThat(x, equalTo(y)), hamcrest runs y.equalTo(x). So if we happen to have an equals method implemented
 * in our asserted object (by Lombok's @Data for instance) we can use this method for asserting and entire object, instead of asserting per field.
 */

@RunWith(MockitoJUnitRunner.class)
public class Exercise1Test {
    @Mock
    CarAdapter carAdapter;

    @InjectMocks
    Exercise1 exercise1;
    @Test
    public void saveCar_shouldSaveAndReturnCar() {
        CarDto carDto = new CarDto();
        carDto.setColour("blue");
        carDto.setMake("Honda");
        carDto.setModel("Civic");
        Car savecar = new Car(carDto);

        ArgumentCaptor<CarDto> captor = ArgumentCaptor.forClass(CarDto.class);

        when(carAdapter.save(captor.capture())).thenReturn(carDto);

        Car savedcar = this.exercise1.saveCar(savecar);
        Assert.assertNotNull(savedcar);
        Assert.assertEquals(savecar,savedcar);
    }
}
