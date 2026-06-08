package org.example.test;

import org.example.input.RandomCarDataInput;
import org.example.list.CustomList;
import org.example.model.Car;

public class RandomCarDataInputTest {

    public static void run() {

        System.out.println("=== RandomCarDataInputTest ===");
        testCount();
        testValues();
    }

    private static void testCount() {

        RandomCarDataInput input = new RandomCarDataInput();

        CustomList<Car> cars = input.load(10);

        if (cars.size() == 10) {
            System.out.println("testCount PASSED");
        } else {
            System.out.println("testCount FAILED");
        }
    }

    private static void testValues() {

        RandomCarDataInput input = new RandomCarDataInput();

        CustomList<Car> cars = input.load(100);

        boolean passed = true;

        for (Car car : cars) {

            if (car.getPower() < 100 ||
                    car.getPower() >= 200) {

                passed = false;
                break;
            }

            if (car.getYear() < 1920 ||
                    car.getYear() >= 2025) {

                passed = false;
                break;
            }

            if (car.getModel() == null ||
                    car.getModel().isBlank()) {

                passed = false;
                break;
            }
        }

        if (passed) {
            System.out.println("testValues PASSED");
        } else {
            System.out.println("testValues FAILED");
        }
    }
}