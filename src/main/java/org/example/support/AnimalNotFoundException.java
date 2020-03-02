package org.example.support;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long code) {
        super("Could not find animal with code: " + code);
    }
}
