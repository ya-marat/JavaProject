package org.example.sort;
import org.example.list.CustomList;
import org.example.model.Car;

import java.util.Comparator;

public class Sort {

    public static void quickSort(CustomList<Car> list, int low, int high, Comparator<Car> comparator) {
            if (low < high) {
                int pi = partition(list, low, high, comparator);
                quickSort(list, low, pi - 1, comparator);
                quickSort(list, pi + 1, high, comparator);
            }
        }
    }

        public static int partition(CustomList<Car> list, int low, int high, Comparator<Car> comparator) {
            Car pivot = list.get(high);
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (comparator.compare(list.get(j), pivot) <= 0) {
                    i++;
                    swap(list, i, j);
                }
            }

            swap(list, i + 1, high);
            return i + 1;
        }

        public static void swap(CustomList<Car> list, int i, int j) {
            Car temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}

