package org.example.test;

import org.example.comparator.CarPowerComparator;
import org.example.model.Car;

public class CarPowerComparatorTest {

    public static void run() {

        System.out.println("=== CarPowerComparatorTest ===");

        Car car1 = new Car.Builder()
                .setPower(100)
                .setModel("BMW")
                .setYear(2020)
                .build();

        Car car2 = new Car.Builder()
                .setPower(200)
                .setModel("Audi")
                .setYear(2019)
                .build();

        Car car3 = new Car.Builder()
                .setPower(200)
                .setModel("BMW")
                .setYear(2019)
                .build();

        Car car4 = new Car.Builder()
                .setPower(200)
                .setModel("BMW")
                .setYear(2022)
                .build();

        Car car5 = new Car.Builder()
                .setPower(200)
                .setModel("BMW")
                .setYear(2022)
                .build();

        CarPowerComparator comparator = new CarPowerComparator();

        boolean powerTest = comparator.compare(car1, car2) < 0;
        boolean modelTest = comparator.compare(car2, car3) < 0;
        boolean yearTest = comparator.compare(car3, car4) < 0;
        boolean equalityTest = comparator.compare(car4, car5) == 0;

        if (powerTest && modelTest && yearTest && equalityTest) {
            System.out.println("CarPowerComparatorTest PASSED");
        } else {
            System.out.println("CarPowerComparatorTest FAILED");
        }
    }
}
