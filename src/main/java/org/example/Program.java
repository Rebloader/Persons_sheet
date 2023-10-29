package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
    private Map<String, List<Person>> personsMap = new HashMap<>();
    private Validator validator;


    public Program(Validator validator) {
        this.validator = validator;
    }

    public void program (String input) {
        try {
            Person person = validator.parseAndValidateData(input);
            String surname = person.getSurname();
            if (!personsMap.containsKey(surname)) {
                personsMap.put(surname, new ArrayList<>());
            }
            personsMap.get(surname).add(person);
        } catch (InvalidDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void saveInFile() {
        for (String surname : personsMap.keySet()) {
            List<Person> persons = personsMap.get(surname);
            try (FileWriter writer = new FileWriter(surname + ".txt", true)) {
                for (Person person : persons) {
                    writer.write("<" + person.getSurname() + "><" + person.getName() + "><" + person.getMiddleName()
                            + "><" + new SimpleDateFormat("dd.MM.yyyy").format(person.getBirthDate())
                            + "><" + person.getPhoneNumber() + "><" + person.getGender() + ">" + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
