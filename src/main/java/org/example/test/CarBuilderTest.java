package org.example.test;

import org.example.model.Car;

public class CarBuilderTest {

    public static void testCreation() {
        Car car = new Car.Builder()
                .setPower(100)
                .setModel("BMW")
                .setYear(2020)
                .build();

        boolean exist = car != null;

        if (exist) {
            boolean powerTest = car.getPower() == 100;
            boolean modelTest = car.getModel().equals("BMW");
            boolean yearTest = car.getYear() == 2020;

            if (powerTest && modelTest && yearTest) {
                System.out.println("CarBuilderTest.testCreation PASSED");
            } else {
                System.out.println("CarBuilderTest.testCreation FAILED");
            }
        } else {
            System.out.println("CarBuilderTest.testCreation FAILED");
        }
    }
    public static void testValidation() {
        Car car = new Car.Builder()
                .setPower(0)
                .setModel("BMW")
                .setYear(2020)
                .build();

        boolean notExist = car == null;

        if (notExist) {
            System.out.println("CarBuilderTest.testValidation PASSED");
        } else {
            System.out.println("CarBuilderTest.testValidation FAILED");
        }
    }
}
