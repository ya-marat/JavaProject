package org.example.comparator;

import org.example.model.Car;

import java.util.Comparator;

public class CarModelComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {

        int modelCompare = car1.getModel().compareTo(car2.getModel());
        if (modelCompare != 0) {
        return modelCompare;
        }

        int powerCompare = Integer.compare(car1.getPower(), car2.getPower());
        if  (powerCompare != 0) {
            return powerCompare;
        }

        return Integer.compare(car1.getYear(), car2.getYear());
    }
}
