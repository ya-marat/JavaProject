package org.example.input;

import org.example.list.CustomList;
import org.example.model.Car;
import org.example.validation.Validator;

import java.util.stream.IntStream;

public class RandomCarDataInput implements Input<Car> {

    String[] carModels = {
            "Toyota",
            "BMW",
            "Mercedes-Benz",
            "Audi",
            "Volkswagen",
            "Ford",
            "Chevrolet",
            "Honda",
            "Nissan",
            "Hyundai",
            "Kia",
            "Lexus",
            "Porsche",
            "Ferrari",
            "Lamborghini",
            "Bentley",
            "Rolls-Royce",
            "Tesla",
            "Volvo",
            "Subaru"
    };

    private final int MIN_POWER_VALUE = 100;
    private final int MAX_POWER_VALUE = 200;

    private final int MIN_MODEL_YEAR = 1920;
    private final int MAX_MODEL_YEAR = 2026;

    @Override
    public CustomList<Car> load(int count) {
        CustomList<Car> result = new CustomList<>();

        IntStream.range(0, count)
                .mapToObj(i -> new Car.Builder()
                        .setModel(carModels[getRandomNumber(0, carModels.length)])
                        .setPower(getRandomNumber(MIN_POWER_VALUE, MAX_POWER_VALUE))
                        .setYear(getRandomNumber(MIN_MODEL_YEAR, MAX_MODEL_YEAR))
                        .build()
                )
                .forEach(result::add);

        return result;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
