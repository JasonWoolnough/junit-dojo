package org.example.support;

import lombok.Data;

@Data
public class Animal {
    private String name;
    private String family;
    private String species;

    private Animal(){};

    public Animal(String name, Long animalCode) {
        AnimalE animalE = AnimalE.fromCode(animalCode);

        this.name = name;
        this.family = animalE.family;
        this.species = animalE.species;
    }

    private enum AnimalE {
        LION(1L, "Cat", "Lion"),
        LEOPARD(2L, "Cat", "Leapard"),
        GRIZZLY(3L, "Bear", "Grizzly"),
        POLAR_BEAR(4L, "Bear", "Polar Bear");

        private final Long code;
        private final String family;
        private final String species;

        AnimalE(Long code, String family, String species) {
            this.code = code;
            this.family = family;
            this.species = species;
        }

        static AnimalE fromCode(Long code) {
            for (AnimalE animal : AnimalE.values()) {
                if (animal.code.equals(code)) {
                    return animal;
                }
            }
            throw new AnimalNotFoundException(code);
        }
    }
}
