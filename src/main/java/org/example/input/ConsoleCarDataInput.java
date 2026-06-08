package org.example.input;

import org.example.list.CustomList;
import org.example.model.Car;
import org.example.validation.Validator;
import java.util.Scanner;
import java.util.stream.Stream;


public class ConsoleCarDataInput implements CarDataInput {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleReader consoleReader = new ConsoleReader(scanner);

    @Override
    public CustomList<Car> load(int count) {
        return Stream.iterate(0, i -> i < count, i -> i + 1)
                .map(i -> readFromConsole())
                .collect(
                        CustomList::new,
                        CustomList::add,
                        (list1, list2) -> {
                            for (Car car : list2) {
                                list1.add(car);
                            }
                        }
                );
    }

    private Car readFromConsole() {
        while (true) {
            try {
                System.out.print("Введите значение мощности. Мощность должна быть больше нуля: ");
                int power = consoleReader.readInt();
                System.out.print("Введите значение модели: ");
                String model = consoleReader.readString();
                System.out.print("Введите значение года: ");
                int year = consoleReader.readInt();
                Validator.validate(power, model, year);
                return new Car.Builder()
                        .setPower(power)
                        .setModel(model)
                        .setYear(year)
                        .build();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
