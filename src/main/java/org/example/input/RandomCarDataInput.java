package org.example.input;

import org.example.list.CustomList;
import org.example.model.Car;

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

        for (int i = 0; i < count; i++) {
            Car newCar = new Car.Builder()
                    .setModel(carModels[getRandomNumber(0, carModels.length)])
                    .setPower(getRandomNumber(MIN_POWER_VALUE, MAX_POWER_VALUE))
                    .setYear(getRandomNumber(MIN_MODEL_YEAR, MAX_MODEL_YEAR))
                    .build();
            result.add(newCar);
        }

        return result;
    }

    @Override
    public CustomList<Car> load(String path) {
        return null;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
