package org.example.input;

import org.example.list.CustomList;
import org.example.model.Car;
import org.example.validation.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileCarDataInput implements CarDataInput {
    private final String FILE_PATH = "src/main/java/org/example/test/Cars.txt";

    @Override
    public CustomList<Car> load(int count) {

        Path filePath = Paths.get(FILE_PATH);
        CustomList<Car> cars = new CustomList<>();

        try (Stream<String> lines = Files.lines(filePath)) {

            lines.map(line -> line.split(", "))
            .limit(count)
            .forEach(parts ->{
                try {
                    Validator.validate(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
                    cars.add(new Car.Builder()
                            .setPower(Integer.parseInt(parts[0]))
                            .setModel(parts[1])
                            .setYear(Integer.parseInt(parts[2]))
                            .build());
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверные данные, пропущена строка");
                }
            });
            return cars;
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            e.printStackTrace();
            return cars;
        }
    }
}
