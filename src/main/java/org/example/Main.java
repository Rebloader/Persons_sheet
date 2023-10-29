package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Validator validator = new DataValidator();
        Program program = new Program(validator);

        Scanner scanner = new Scanner(System.in);

        String input;
        while (true) {
            System.out.print("Введите данные через пробел (Фамилия Имя Отчество, дата рождения, телефон, пол) или 'exit' для выхода: ");
            input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }
            program.program(input);
        }

        program.saveInFile();
    }
}