package org.example.test;

import org.example.comparator.CarModelComparator;
import org.example.list.CustomList;
import org.example.model.Car;
import org.example.sort.Sort;

public class SortTest {

    public static void run() {
        System.out.println("=== SortTest ===");
        testSortModel();
    }

    private static void testSortModel() {

        CustomList<Car> testCars = new CustomList<Car>();
        CustomList<Car> sortedCars = createSortCars();

        Car car1 = new Car.Builder()
                .setYear(2012)
                .setPower(200)
                .setModel("KIA")
                .build();

        Car car2 = new Car.Builder()
                .setYear(2003)
                .setPower(150)
                .setModel("BMW")
                .build();

        Car car3 = new Car.Builder()
                .setYear(2002)
                .setPower(100)
                .setModel("Audi")
                .build();

        testCars.add(car1);
        testCars.add(car2);
        testCars.add(car3);

        Sort.quickSort(testCars, 0, testCars.size() - 1, new CarModelComparator());

        testCars.forEach(it -> System.out.println(it.toString()));

        boolean isPassed = testCars.equals(sortedCars);

        if (isPassed) {
            System.out.println("testSortModel PASSED");
        } else {
            System.out.println("testSortModel FAILED");
        }
    }

    private static CustomList<Car> createSortCars() {

        Car car1 = new Car.Builder()
                .setYear(2002)
                .setPower(100)
                .setModel("Audi")
                .build();

        Car car2 = new Car.Builder()
                .setYear(2003)
                .setPower(150)
                .setModel("BMW")
                .build();

        Car car3 = new Car.Builder()
                .setYear(2012)
                .setPower(200)
                .setModel("KIA")
                .build();

        CustomList<Car> cars = new CustomList<Car>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        return cars;
    }
}
