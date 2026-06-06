package org.example.sort;
import org.example.comparator.CarPowerComparator;
import org.example.list.CustomList;
import org.example.model.Car;

import java.util.Arrays;

// TODO Переписать под CustomList
public class EvenSort {

    public static void addCarSort(Car[] arr) {
        if (arr == null || arr.length <= 1) return;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPower() % 2 == 0) {
                count++;
            }
        }

        if (count <= 1) return;
        Car[] carsToSort = new Car[count];
        int[] ind = new int[count];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPower() % 2 == 0) {
                carsToSort[j] = arr[i];
                ind[j] = i;
                j++;
            }
        }

        //Sort.quickSort(carsToSort, 0, count - 1, new CarPowerComparator());
        for (int i = 0; i < count; i++) {
            arr[ind[i]] = carsToSort[i];
        }
    }
}

