

package org.example;


import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

import org.example.comparator.CarModelComparator;
import org.example.comparator.CarPowerComparator;
import org.example.comparator.CarYearComparator;
import org.example.input.*;
import org.example.list.CustomList;
import org.example.model.Car;
import org.example.multithreading.ThreadSearch;
import org.example.sort.Sort;
import org.example.util.FileReportWriter;


// Обьединенный класс Main c Реализацией меню
public class Main {

    private CustomList<Car> cars = new CustomList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final ThreadSearch threadSearch = new ThreadSearch();
    private final ConsoleReader consoleReader = new ConsoleReader(scanner);

    Map<Class<?>, CarDataInput> inputs = Map.of(
            RandomCarDataCarDataInput.class, new RandomCarDataCarDataInput(),
            ConsoleCarDataCarDataInput.class, new ConsoleCarDataCarDataInput(),
            DataFromFile.class, new DataFromFile()
    );

    Map<Class<?>, Comparator<Car>> comparators = Map.of(
            CarModelComparator.class, new CarModelComparator(),
            CarPowerComparator.class, new CarPowerComparator(),
            CarYearComparator.class, new CarYearComparator()
    );


    public static void main(String[] args) {
        Main app = new Main();
        app.runMenu();
    }

    public void runMenu() {
        //Цикл обработки команд меню
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - заполнить коллекцию");
            System.out.println("2 - вывести коллекцию");
            System.out.println("3 - отсортировать коллекцию");
            System.out.println("4 - добавить коллекцию в файл");
            System.out.println("5 - посчитать совпадения в нескольких потоках");
            System.out.println("0 - выход");

            int choice = consoleReader.readInt();
            switch (choice) {
                case 1:
                    fillCollection();
                    break;
                case 2:
                    printCollection();
                    break;
                case 3:
                    sortStyle();
                    break;
                case 4:
                    FileReportWriter.saveResult("Добавление", cars);
                    break;
                case 5:
                    threadSearch();
                    break;
                case 0:
                    System.out.println("Завершение работы...");
                    consoleReader.closeInput();
                    return;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
    }

    // Метод заполнения коллекции тремя способами
    private void fillCollection() {

        int size = sizeOfCollection();

        System.out.println("Способы заполнения:\n1 - из файла\n2 - случайно\n3 - вручную");
        System.out.print("Выберите источник: ");

        int source = consoleReader.readInt();

        CarDataInput carDataInput = null;

        switch (source) {
            case 1:
                carDataInput = inputs.get(DataFromFile.class);
                break;
            case 2:
                carDataInput = inputs.get(RandomCarDataCarDataInput.class);
                break;
            case 3:
                carDataInput = inputs.get(ConsoleCarDataCarDataInput.class);
                break;
            default:
                System.out.println("Ошибка выбора источника.");
        }

        if (carDataInput != null) {
            cars = carDataInput.load(size);
        }
    }

    // Метод выбора алгоритма сортировки
    private void sortStyle() {
        System.out.println("Алгоритмы сортировки:\n1 - Обычная сортировка\n2 - сортировка только автомобилей с четной мощностью");
        System.out.print("Выберите алгоритм: ");

        int type = consoleReader.readInt();

        switch (type) {
            case 1:
                sortCollection();
                break;
            case 2:
                System.out.println("сортировка по четной мощности в разработке...");
                //EvenSort.sort(cars);
                break;

            default:
                System.out.println("Ошибка выбора алгоритма сортировки.");
        }
    }

    // Метод сортировки по одному из полей
    private void sortCollection() {
        System.out.println("Способы сортировки:\n1 - мощность\n2 - модель\n3 - год производства");
        System.out.print("Выберите поле сортировки: ");
        Comparator<Car> comparator = null;

        int type = consoleReader.readInt();

        switch (type) {
            case 1:
                comparator = comparators.get(CarPowerComparator.class);
                break;
            case 2:
                comparator = comparators.get(CarModelComparator.class);
                break;
            case 3:
                comparator = comparators.get(CarYearComparator.class);
                break;
            default:
                System.out.println("Ошибка выбора типа сортировки.");
        }

        if (comparator != null) {
            Sort.quickSort(cars, 0, cars.size() - 1, comparator);
        }
    }

    // Метод установки размера коллекции
    private int sizeOfCollection() {
        System.out.print("Введите количество элементов коллекции: ");
        return consoleReader.readInt();
    }

    // Метод вывода коллекции в консоль
    private void printCollection() {
        if (cars == null || cars.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        System.out.println("--- Элементы коллекции ---");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private void threadSearch() {

        if (cars.isEmpty()) {
            System.out.println("Коллекция пустая. Сначала заполните ее.");
            return;
        }

        System.out.println("По какому полю произвести подсчет?\n1.Мощность\n2.Год\n3.Модель");
        int type = consoleReader.readInt();

        switch (type) {
            case 1:
                System.out.println("Введите значение мощности: ");
                int power = consoleReader.readInt();
                System.out.println("Колличество элементов по запросу Мощность: " + threadSearch.countByPower(cars, power));
                break;
            case 2:
                System.out.println("Введите год: ");
                int year = consoleReader.readInt();
                System.out.println("Колличество элементов по запросу Год: " + threadSearch.countByYear(cars, year));
                break;
            case 3:
                System.out.println("Введите модель: ");
                String model = consoleReader.readString();
                System.out.println("Колличество элементов по запросу Модель: " + threadSearch.countByModel(cars, model));
                break;
            default:
                System.out.println("Ошибка выбора типа сортировки.");
        }
    }
}









