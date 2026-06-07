package org.example.comparator;

import org.example.model.Car;

import java.util.Comparator;


//Компаратор для сортировки автомобилей по полю "год выпуска"

public class CarYearComparator implements Comparator<Car> {



   @Override
   public int compare(Car car1, Car car2) {

        int yearComparison = Integer.compare(car1.getYear(), car2.getYear());

        if (yearComparison != 0) {
            return yearComparison;//возвр. разн. если год разн.
        }

        int powerCompare = Integer.compare(car1.getPower(), car2.getPower());

        if (powerCompare != 0) {
            return powerCompare;//возвр. разн. если мощн разн.
        }

        return car1.getModel().compareTo(car2.getModel());

    }

}