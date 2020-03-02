package org.example;

import org.example.support.AnimalRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * This one is deceptive. It initially looks like it will be a single test.
 *
 * But don't be fooled! This class invokes the Animal class constructor, which has a bunch of logic in it.
 * Because Animal is not an injected dependency but a stateful object instantiated INSIDE the tested code, we need to test it too.
 */

@RunWith(MockitoJUnitRunner.class)
public class Exercise2Test {
    @Mock
    AnimalRepo animalRepo;

    @InjectMocks
    Exercise2 exercise2;

    /**
     * This one is really easy. Use an argument captor to make sure the correct Animal object is saved.
     */
    @Test
    public void saveAnimal_shouldSaveAnimal() {

    }

    /**
     * Call saveAnimal with a null value for animalCode and expect an exception.
     */
    @Test
    public void saveAnimal_shouldThrowAnimalNotFoundExceptionIfNullAnimalCodeProvided() {

    }

    /**
     * Call saveAnimal with a non-valid Long. A negative long like -1L or an out-of-range long like 10L will do.
     *
     * This isn't technically necessary for code coverage, but null safety and out-of-range tests are normally useful as separate tests.
     */
    @Test
    public void saveAnimal_shouldThrowAnimalNotFoundExceptionIfInvalidAnimalCodeProvided() {

    }
}
