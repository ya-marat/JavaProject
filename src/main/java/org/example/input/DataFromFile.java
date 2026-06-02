package org.example.input;

import org.example.list.CustomList;
import org.example.model.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataFromFile implements Input<Car>{
    private final String FILE_PATH = "src/main/java/org/example/test/Cars.txt";

    @Override
    public CustomList<Car> load(int count) {

        Path filePath = Paths.get(FILE_PATH);
        CustomList<Car> cars = new CustomList<>();

        try {
            List<String> lines = Files.readAllLines(filePath);
            int counter = 0;

            for (String line : lines) {
                if (counter > count) {
                    break;
                }
                String[] parts = line.split(", ");
                //ToDo добавить валидацию типа DataValidator.isValid(parts[0], parts[1], parts[2])
                if (parts.length == 3) {
                    cars.add(new Car.Builder()
                            .setPower(Integer.parseInt(parts[0]))
                            .setModel(parts[1])
                            .setYear(Integer.parseInt(parts[2]))
                            .build());
                }
                counter++;
            }
            return cars;
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
