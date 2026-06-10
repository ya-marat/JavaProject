package org.example.test;

import org.example.list.CustomList;
import org.example.model.Car;
import org.example.sort.Sort;
import org.example.sort.EvenSort;

public class EvenSortTest {

    public static void run() {
        System.out.println("===EvenSortTest===");
        testEvenSort();
    }

    private static void testEvenSort() {
        CustomList<Car> testCars = new CustomList<Car>();
        CustomList<Car> sortedCars = createEvenSortedCars();

        Car car1 = new Car.Builder()
                .setYear(2001)
                .setPower(103)
                .setModel("Subaru")
                .build();

        Car car2 = new Car.Builder()
                .setYear(2005)
                .setPower(200)
                .setModel("Audi")
                .build();

        Car car3 = new Car.Builder()
                .setYear(2007)
                .setPower(150)
                .setModel("BMW")
                .build();

        Car car4 = new Car.Builder()
                .setYear(2009)
                .setPower(135)
                .setModel("Lexus")
                .build();

        Car car5 = new Car.Builder()
                .setYear(2020)
                .setPower(300)
                .setModel("KIA")
                .build();

        testCars.add(car1);
        testCars.add(car2);
        testCars.add(car3);
        testCars.add(car4);
        testCars.add(car5);

        EvenSort.sort(testCars);

        testCars.forEach(it -> System.out.println(it.toString()));

        boolean isPassed = testCars.equals(sortedCars);

        if (isPassed) {
            System.out.println("testEvenSort PASSED");
        } else {
            System.out.println("testEvenSort FAILED");
        }
    }

    private static CustomList<Car> createEvenSortedCars() {

        Car car1 = new Car.Builder()
                .setYear(2001)
                .setPower(103)
                .setModel("Subaru")
                .build();

        Car car2 = new Car.Builder()
                .setYear(2007)
                .setPower(150)
                .setModel("BMW")
                .build();

        Car car3 = new Car.Builder()
                .setYear(2005)
                .setPower(200)
                .setModel("Audi")
                .build();

        Car car4 = new Car.Builder()
                .setYear(2009)
                .setPower(135)
                .setModel("Lexus")
                .build();

        Car car5 = new Car.Builder()
                .setYear(2020)
                .setPower(300)
                .setModel("KIA")
                .build();

        CustomList<Car> cars = new CustomList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        return cars;
    }
}