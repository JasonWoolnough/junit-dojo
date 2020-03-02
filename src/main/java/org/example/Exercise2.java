package org.example;

import org.example.support.Animal;
import org.example.support.AnimalRepo;

public class Exercise2 {
    private final AnimalRepo animalRepo;

    public Exercise2(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    public void saveAnimal(String name, Long animalCode) {
        animalRepo.save(new Animal(name, animalCode));
    }
}
