package org.example.test;

import org.example.multithreading.ThreadSearch;
import org.example.list.CustomList;
import org.example.model.Car;

public class MultiThreadCount {

    public static void run() {

        testCountByModel();
        testCountByPower();
        testCountByYear();
        testEmptyCollection();
        testSingleElementCollection();
    }

    private static void testCountByModel() {

        CustomList<Car> cars = new CustomList<>();

        cars.add(new Car.Builder()
                .setModel("BMW")
                .setPower(200)
                .setYear(2020)
                .build());

        cars.add(new Car.Builder()
                .setModel("Audi")
                .setPower(300)
                .setYear(2021)
                .build());

        cars.add(new Car.Builder()
                .setModel("BMW")
                .setPower(150)
                .setYear(2019)
                .build());

        ThreadSearch search = new ThreadSearch();

        int result = search.countByModel(cars, "BMW");
        printResult("testCountByModel", result == 2);
    }

    private static void testCountByPower() {

        CustomList<Car> cars = new CustomList<>();

        cars.add(new Car.Builder()
                .setModel("BMW")
                .setPower(200)
                .setYear(2020)
                .build());

        cars.add(new Car.Builder()
                .setModel("Audi")
                .setPower(200)
                .setYear(2021)
                .build());

        cars.add(new Car.Builder()
                .setModel("Toyota")
                .setPower(150)
                .setYear(2019)
                .build());

        ThreadSearch search = new ThreadSearch();

        int result = search.countByPower(cars, 200);
        printResult("testCountByPower", result == 2);
    }

    private static void testCountByYear() {

        CustomList<Car> cars = new CustomList<>();

        cars.add(new Car.Builder()
                .setModel("BMW")
                .setPower(200)
                .setYear(2020)
                .build());

        cars.add(new Car.Builder()
                .setModel("Audi")
                .setPower(300)
                .setYear(2020)
                .build());

        cars.add(new Car.Builder()
                .setModel("Toyota")
                .setPower(150)
                .setYear(2019)
                .build());

        ThreadSearch search = new ThreadSearch();

        int result = search.countByYear(cars, 2020);
        printResult("testCountByYear", result == 2);
    }

    private static void testEmptyCollection() {

        CustomList<Car> cars = new CustomList<>();

        ThreadSearch search = new ThreadSearch();

        int result = search.countByModel(cars, "BMW");
        printResult("testEmptyCollection", result == 0);
    }

    private static void testSingleElementCollection() {

        CustomList<Car> cars = new CustomList<>();

        cars.add(new Car.Builder()
                .setModel("BMW")
                .setPower(200)
                .setYear(2020)
                .build());

        ThreadSearch search = new ThreadSearch();

        int result = search.countByModel(cars, "BMW");
        printResult("testSingleElementCollection", result == 1);
    }

    private static void printResult(String testName, boolean passed) {
        System.out.println(testName + ": " + (passed ? "PASSED" : "FAILED"));
    }
}
