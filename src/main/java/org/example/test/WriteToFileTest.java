package org.example.test;

import org.example.list.CustomList;
import org.example.model.Car;
import org.example.util.FileReportWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteToFileTest {

    public static void run() {
        Path path = Paths.get("src/main/java/org/example/test/report_history.txt");

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

        CustomList<Car> cars = new CustomList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        FileReportWriter.saveResult("Добавление", cars);

        if (Files.exists(path)) {
            System.out.println("WriteToFileTest PASSED");
        } else {
            System.out.println("WriteToFileTest FAILED");
        }
    }
}
