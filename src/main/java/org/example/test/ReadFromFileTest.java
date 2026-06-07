package org.example.test;

import org.example.comparator.CarPowerComparator;
import org.example.input.FileCarDataInput;
import org.example.list.CustomList;
import org.example.model.Car;

public class ReadFromFileTest {
    private FileCarDataInput fileCarDataInput;

    public static void run() {
        Car car1 = new Car.Builder()
                .setPower(200)
                .setModel("BMW")
                .setYear(2010)
                .build();

        Car car2 = new Car.Builder()
                .setPower(300)
                .setModel("Audi")
                .setYear(2015)
                .build();

        Car car3 = new Car.Builder()
                .setPower(150)
                .setModel("Mercedes")
                .setYear(2012)
                .build();

        FileCarDataInput fileCarDataInput = new FileCarDataInput();
        CarPowerComparator comparator = new CarPowerComparator();
        //Чтение из файла
        CustomList<Car> cars = fileCarDataInput.load(3);

        boolean notNull = cars != null;

        if (notNull) {
            boolean sizeTest = cars.size() == 3;
            boolean equalsTest = comparator.compare(cars.get(2), car3) == 0;

            if (sizeTest && equalsTest) {
                System.out.println("ReadFromFileTest PASSED");
            } else {
                System.out.println("ReadFromFileTest FAILED");
            }
        } else {
            System.out.println("ReadFromFileTest FAILED");
        }
    }
}
