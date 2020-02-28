package org.example.support;

import org.example.support.PersonDto;

public class Demo2Dependency {
    public void savePerson(PersonDto personDto) {
    }

    public PersonDto updatePerson(PersonDto personDto) {
        return personDto;
    }
}
