package org.example;

import org.example.support.Demo2Dependency;
import org.example.support.PersonDto;

public class Demo2 {
    private final Demo2Dependency personAdapter;

    public Demo2(Demo2Dependency PersonAdapter) {
        this.personAdapter = PersonAdapter;
    }

    /**
     * @param fullName first name and surname separated by a space
     */
    public void createPerson(String fullName) {
        PersonDto personDto = toPersonDto(fullName);

        personAdapter.savePerson(personDto);
    }

    public PersonDto updatePerson(String fullName) {
        PersonDto personDto = toPersonDto(fullName);

        return personAdapter.updatePerson(personDto);
    }

    private PersonDto toPersonDto(String fullName) {
        String[] names = fullName.split(" ");

        if (names.length != 2) {
            throw new RuntimeException("Provided full name must be name and surname separated by a space!");
        }

        PersonDto personDto = new PersonDto();
        personDto.setName(names[0]);
        personDto.setSurname(names[1]);

        return personDto;
    }


}
