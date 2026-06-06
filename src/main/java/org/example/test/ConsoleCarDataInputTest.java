package org.example.test;

import org.example.input.ConsoleCarDataInput;
import org.example.list.CustomList;
import org.example.model.Car;


public class ConsoleCarDataInputTest {
    public static void main(String[] args) {

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

        CustomList<Car> expectedData = new CustomList<>();
        expectedData.add(car1);
        expectedData.add(car2);
        expectedData.add(car3);

        ConsoleCarDataInput consoleCarDataInput = new ConsoleCarDataInput();
        var testData = consoleCarDataInput.load(3);

        if (testData.equals(expectedData)) {
            System.out.println("ConsoleCarDataInputTest PASSED");
        } else {
            System.out.println("ConsoleCarDataInputTest FAILED");
        }
    }
}
