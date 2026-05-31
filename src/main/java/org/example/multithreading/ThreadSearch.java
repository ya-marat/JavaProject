package org.example.multithreading;

import org.example.list.CustomList;
import org.example.model.Car;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class ThreadSearch {

    public int countByModel(CustomList<Car> cars, String name) {
        return countElements(cars, car -> car.getModel().equals(name));
    }

    public int countByPower(CustomList<Car> cars, int power){
        return countElements(cars, car -> car.getPower() == power);
    }

    public int countByYear(CustomList<Car> cars, int year) {
        return countElements(cars, car -> car.getYear() == year);
    }

    private int countElements(CustomList<Car> cars, Predicate<Car> predicate) {

        int middle = cars.size() / 2;

        AtomicInteger count = new AtomicInteger();

        Thread firstThread = new Thread(() -> {
            count(cars, predicate, 0, middle, count);
        });

        Thread secondThread = new Thread(() -> {
            count(cars, predicate, middle, cars.size(), count);
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return count.get();
    }

    private void count(CustomList<Car> cars, Predicate<Car> predicate, int start, int end, AtomicInteger count) {
        for (int i = start; i < end; i++) {
            if (predicate.test(cars.get(i))) {
                count.incrementAndGet();
            }
        }
    }
}
