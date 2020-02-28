package org.example;

import org.example.support.CarAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Exercise1Test {
    @Mock
    CarAdapter carAdapter;

    @InjectMocks
    Exercise1 exercise1;

    @Test
    public void saveCar_testTheThing() {

    }
}
