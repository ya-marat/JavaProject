package org.example.sort;

import org.example.comparator.CarPowerComparator;
import org.example.list.CustomList;
import org.example.model.Car;

public class EvenSort {

    public static void sort(CustomList<Car> list) {
        if (list == null || list.size() <= 1) return;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            Car car = list.get(i);
            if (car != null && car.getPower() % 2 == 0) {
                count++;
            }
        }

        if (count <= 1) return;
        CustomList<Car> carsToSort = new CustomList<>();
        int[] ind = new int[count];
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            Car car = list.get(i);
            if (car != null && car.getPower() % 2 == 0) {
                carsToSort.add(car);
                ind[j] = i;
                j++;
            }
        }

        Sort.quickSort(carsToSort, 0, count - 1, new CarPowerComparator());
        for (int i = 0; i < count; i++) {
            list.set(ind[i], carsToSort.get(i));
        }
    }
}

