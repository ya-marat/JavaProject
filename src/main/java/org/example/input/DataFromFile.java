package org.example.input;

import org.example.list.CustomList;
import org.example.model.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataFromFile implements Input<Car> {

    @Override
    public CustomList<Car> load(String path) {
        Path filePath = Paths.get(path);
        CustomList<Car> cars = new CustomList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                String[] parts = line.split(", ");
                //TODO добавить валидацию типа DataValidator.isValid(parts[0], parts[1], parts[2])
                if (parts.length == 3) {
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

    @Override
    public CustomList<Car> load(int count) {
        return null;
    }
}
