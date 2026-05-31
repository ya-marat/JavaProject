package org.example.sort;
import org.example.model.Car;
import java.util.Comparator;

public class Sort {
         public static void quickSort(Car[] arr, int low, int high, Comparator<Car> comparator) {
            if (low < high) {
                int pi = partition(arr, low, high, comparator);
                quickSort(arr, low, pi - 1, comparator);
                quickSort(arr, pi + 1, high, comparator);
            }
        }

        public static int partition(Car[] arr, int low, int high, Comparator<Car> comparator) {
            Car pivot = arr[high];
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (comparator.compare(arr[j], pivot) <= 0) {
                    i++;
                    swap(arr, i, j);
                }
            }

            swap(arr, i + 1, high);
            return i + 1;
        }

        public static void swap(Car[] arr, int i, int j) {
            Car temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

