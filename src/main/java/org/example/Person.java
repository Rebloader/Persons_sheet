package org.example;

import java.util.Date;

public class Person {
    private String surname;
    private String name;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String surname, String name, String middleName, Date birthDate, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                '}';
    }
}
