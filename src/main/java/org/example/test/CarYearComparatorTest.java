package org.example.test;

import org.example.comparator.CarYearComparator;
import org.example.model.Car;


public class CarYearComparatorTest {


    public static void run() {
        System.out.println("Test");
        testCompareByYear();

    }

    // Тестируемый обьект
    private static final CarYearComparator comparator = new CarYearComparator();



    public static void testCompareByYear() {
        // Создаем экземпляры
        Car car1 = new Car.Builder()
                .setPower(150)
                .setModel("Toyota")
                .setYear(2020)
                .build();

        Car car2 = new Car.Builder()
                .setPower(160)
                .setModel("Honda")
                .setYear(2021)
                .build();


        // Ожидаем отицательное значение, так как car1 старше car2
        int result1 = comparator.compare(car1, car2);

        // Меняем местами для проверки обратного случая
        int result2 = comparator.compare(car2, car1);

        if ((!(result1 < 0)) && (!(result2 > 0))) {
            System.out.println("CarYearComparatorTest FAILED");
        }
        System.out.println("CarYearComparatorTest PASSED");
    }
}
