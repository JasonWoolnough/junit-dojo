package org.example;

import org.example.support.Demo2Dependency;
import org.example.support.PersonDto;
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

@RunWith(MockitoJUnitRunner.class)
public class Demo2Test {
    @Mock
    Demo2Dependency personAdapter;

    @InjectMocks
    Demo2 demo2;

    // This is trickier to test! There's no returned object to inspect. We use an argumentCaptor instead.
    @Test
    public void createPerson_shouldSaveWithPersonAdapter() {
        // This thing is awesome! It's good for inspecting argument's you've passed to a mock.
        // (In this case, we can capture PersonDto that we give to personAdapter.)
        ArgumentCaptor<PersonDto> captor = ArgumentCaptor.forClass(PersonDto.class);

        demo2.createPerson("Jason Woolnough");

        // Verify - this is a handy when we want to test void-returning methods. We have no "result" to inspect, so we instead confirm that the void call as made.
        verify(personAdapter).savePerson(captor.capture());
        PersonDto personDto = captor.getValue();

        assertThat(personDto.getName(), equalTo("Jason"));
        assertThat(personDto.getSurname(), equalTo("Woolnough"));
    }

    @Test
    public void createPerson_shouldThrowExceptionIfNoSpacesIncluded() {
        try {
            demo2.createPerson("JasonWoolnough");
            Assert.fail("Should have thrown exception by this stage!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), equalTo("Provided full name must be name and surname separated by a space!"));
        } catch (Throwable t) {
            Assert.fail("Should have thrown RuntimeException, not " + t.getClass().getSimpleName());
        }
    }

    @Test
    public void createPerson_shouldThrowExceptionIfMoreThanTwoNames() {
        try {
            demo2.createPerson("Jason Robin Woolnough");
            Assert.fail("Should have thrown exception by this stage!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), equalTo("Provided full name must be name and surname separated by a space!"));
        } catch (Throwable t) {
            Assert.fail("Should have thrown RuntimeException, not " + t.getClass().getSimpleName());
        }
    }

    // Because our dependency returns an object, we can replace the verify with a when() declaration, and inspect the returned object :)
    // However, we still need an argumentCaptor because the method constructs a brand new PersonDto, and we have to ensure it's built correctly.
    @Test
    public void updatePerson_shouldUpdateAndReturnPerson() {
        PersonDto expectedPerson = new PersonDto();
        ArgumentCaptor<PersonDto> captor = ArgumentCaptor.forClass(PersonDto.class);

        when(personAdapter.updatePerson(captor.capture())).thenReturn(expectedPerson);
        PersonDto actualPerson = demo2.updatePerson("Jason Woolnough");

        PersonDto updatedPerson = captor.getValue();

        // Firstly, make sure we correctly constructed the PersonDto to be updated
        assertThat(updatedPerson.getName(), equalTo("Jason"));
        assertThat(updatedPerson.getSurname(), equalTo("Woolnough"));

        // Then make sure we correctly return the updated PersonDto
        assertThat(actualPerson, equalTo(expectedPerson));
    }

    @Test
    public void updatePerson_shouldThrowExceptionIfNoSpacesIncluded() {
        try {
            demo2.updatePerson("JasonWoolnough");
            Assert.fail("Should have thrown exception by this stage!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), equalTo("Provided full name must be name and surname separated by a space!"));
        } catch (Throwable t) {
            Assert.fail("Should have thrown RuntimeException, not " + t.getClass().getSimpleName());
        }
    }

    @Test
    public void updatePerson_shouldThrowExceptionIfMoreThanTwoNames() {
        try {
            demo2.updatePerson("Jason Robin Woolnough");
            Assert.fail("Should have thrown exception by this stage!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), equalTo("Provided full name must be name and surname separated by a space!"));
        } catch (Throwable t) {
            Assert.fail("Should have thrown RuntimeException, not " + t.getClass().getSimpleName());
        }
    }
}
