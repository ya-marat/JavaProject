package org.example.util;

import org.example.builder.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataFromFile {
    public static ArrayList<Car> readFromFile(String path) {
        Path filePath = Paths.get(path);
        ArrayList<Car> cars = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                String[] parts = line.split(", ");
                if (parts.length == 3 && DataValidator.isValid(parts[0], parts[1], parts[2])) {
                    cars.add(new Car.Builder()
                            .setPower(Integer.parseInt(parts[0]))
                            .setModel(parts[1])
                            .setPower(Integer.parseInt(parts[2]))
                            .build());
                }
            }
            return cars;
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return null;
        }
    }
}
