package org.example.comparator;


import org.example.model.Car;
import java.util.Comparator;



//Компаратор для сортировки автомобилей по полю "год выпуска"

public class CarYearComparator implements Comparator<Car> {

    /**
     *
     * @param car1
     * @param car2
     * @return
     */
    @Override
    public int compare(Car car1, Car car2) {

        int yearComparsion = Integer.compare(car1.getYear(), car2.getYear());
        if (yearComparsion != 0) {
            return yearComparsion;//возвр. разн. если год разн.
        }

        return Integer.compare(car1.getPower(), car2.getPower());

    }
}
