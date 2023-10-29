package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataValidator implements Validator{

    @Override
    public Person parseAndValidateData(String input) throws InvalidDataException {
        String[] contact = input.split(" ");
        if (contact.length != 6) {
            throw new InvalidDataException("Неверное количество параметров.");
        }

        String surname = contact[0];
        String name = contact[1];
        String middleName = contact[2];

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDate;
        try {
            birthDate = dateFormat.parse(contact[3]);
        } catch (Exception e) {
            throw new InvalidDataException("Неверный формат. Введите dd.mm.yyyy.");
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(contact[4]);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Неверный формат. Используйте целое беззнаковое число.");
        }

        char gender = contact[5].charAt(0);
        if (gender != 'f' && gender != 'm') {
            throw new InvalidDataException("Неверное значение пола. Используйте 'f' или 'm'.");
        }

        return new Person(surname, name, middleName, birthDate, phoneNumber, gender);
    }
}
