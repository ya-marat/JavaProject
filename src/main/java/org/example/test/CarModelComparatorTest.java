package org.example.test;

import org.example.comparator.CarModelComparator;
import org.example.model.Car;

public class CarModelComparatorTest {

    public static void run() {

        Car car1 = new Car.Builder()
                .setPower(150)
                .setModel("Audi")
                .setYear(2020)
                .build();

        Car car2 = new Car.Builder()
                .setPower(200)
                .setModel("BMW")
                .setYear(2019)
                .build();

        Car car3 = new Car.Builder()
                .setPower(250)
                .setModel("BMW")
                .setYear(2019)
                .build();

        Car car4 = new Car.Builder()
                .setPower(250)
                .setModel("BMW")
                .setYear(2022)
                .build();

        Car car5 = new Car.Builder()
                .setPower(250)
                .setModel("BMW")
                .setYear(2022)
                .build();

        CarModelComparator comparator = new CarModelComparator();

        boolean modelTest = comparator.compare(car1, car2) < 0;
        boolean powerTest = comparator.compare(car2, car3) < 0;
        boolean yearTest = comparator.compare(car3, car4) < 0;
        boolean equalityTest = comparator.compare(car4, car5) == 0;

        if (modelTest && powerTest && yearTest && equalityTest) {
            System.out.println("CarModelComparatorTest PASSED");
        } else {
            System.out.println("CarModelComparatorTest FAILED");
        }
    }
}