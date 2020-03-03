package org.example;

import org.example.support.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This one is deceptive. It initially looks like it will be a single test.
 * <p>
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
        Animal animal = new Animal("Faheem", 1L);

        exercise2.saveAnimal("Faheem", 1L);

        ArgumentCaptor<Animal> captor = ArgumentCaptor.forClass(Animal.class);

        verify(animalRepo).save(captor.capture());

        Animal animal1 = captor.getValue();

        assertThat(animal1.getName(), equalTo("Faheem"));
        assertThat(animal1.getFamily(), equalTo("Cat"));

    }

    /**
     * Call saveAnimal with a null value for animalCode and expect an exception.
     */
    @Test
    public void saveAnimal_shouldThrowAnimalNotFoundExceptionIfNullAnimalCodeProvided() {
        try {
            exercise2.saveAnimal("Faheem", null);
            Assert.fail("Should have failed");
        } catch (AnimalNotFoundException ae) {
            assertThat(ae.getMessage(), equalTo("Could not find animal with code: " + null));
        } catch (Throwable t) {
            Assert.fail("Should have thrown the AnimalNotFoundException but instead it through some weird shit:" + t.getMessage());
        }
    }

    /**
     * Call saveAnimal with a non-valid Long. A negative long like -1L or an out-of-range long like 10L will do.
     * <p>
     * This isn't technically necessary for code coverage, but null safety and out-of-range tests are normally useful as separate tests.
     */
    @Test
    public void saveAnimal_shouldThrowAnimalNotFoundExceptionIfInvalidAnimalCodeProvided() {
        try {
            exercise2.saveAnimal("Faheem", -1L);
            Assert.fail("Should have failed");
        } catch (AnimalNotFoundException ae) {
            assertThat(ae.getMessage(), equalTo("Could not find animal with code: " + -1L));
        } catch (Throwable t) {
            Assert.fail("Should have thrown the AnimalNotFoundException but instead it through some weird shit:" + t.getMessage());
        }
    }
}
