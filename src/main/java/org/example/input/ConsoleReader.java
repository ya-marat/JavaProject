package org.example.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt() {

        while (true) {

            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {

                System.out.println("Введите целое число.");
                scanner.nextLine();
            }
        }
    }

    public String readString() {

        while (true) {

            String model = scanner.next().trim();

            if (model.isBlank()) {
                System.out.println("Строка не может быть пустой.");
                continue;
            }

            if (model.matches("\\d+")) {
                System.out.println("Строка не может состоять только из цифр.");
                continue;
            }

            return model;
        }
    }

    public void closeInput() {
        if (scanner == null) {
            return;
        }

        scanner.close();
    }
}
