package org.example.sort;

import org.example.list.CustomList;
import org.example.model.Car;

import java.util.Comparator;

public class Sort {

    public static void quickSort(CustomList<Car> arr, int low, int high, Comparator<Car> comparator) {
        if (low < high) {
            int pi = partition(arr, low, high, comparator);
            quickSort(arr, low, pi - 1, comparator);
            quickSort(arr, pi + 1, high, comparator);
        }
    }

    private static int partition(CustomList<Car> arr, int low, int high, Comparator<Car> comparator) {
        Car pivot = arr.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (comparator.compare(arr.get(j), pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(CustomList<Car> arr, int i, int j) {
        Car temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}

