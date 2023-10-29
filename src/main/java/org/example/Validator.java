package org.example;

public interface Validator {
    Person parseAndValidateData(String input) throws InvalidDataException;
}
