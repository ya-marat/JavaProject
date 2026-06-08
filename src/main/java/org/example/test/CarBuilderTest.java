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
}
