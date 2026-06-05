

package org.example;




import java.util.Comparator;
import java.util.Scanner;

import org.example.comparator.CarModelComparator;
import org.example.comparator.CarPowerComparator;
import org.example.comparator.CarYearComparator;
import org.example.input.ConsoleCarDataInput;
import org.example.input.DataFromFile;
import org.example.input.RandomCarDataInput;
import org.example.list.CustomList;
import org.example.model.Car;
import org.example.util.FileReportWriter;
import org.example.sort.Sort;
import org.example.sort.EvenSort;





// Обьединенный класс Main c Реализацией меню
public class Main {
    //поля класса
    private final DataFromFile dataFromFile = new DataFromFile();
    private CustomList<Car> cars = new CustomList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final RandomCarDataInput randomCarDataInput = new RandomCarDataInput();
    private final ConsoleCarDataInput consoleCarDataInput = new ConsoleCarDataInput();
    private int size;




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

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    fillCollection();
                    break;
                case 2:
                    printCollection();
                    break;
                case 3:
                    //TODO: Подключено, но сортировка по четной мощности работает странно.
                    sortStyle();
                    break;
                case 4:
                    //TODO Непонятно FileReportWriter подключить или что-то другое будет создаваться, чтобы добавлять в файл
                    //FileReportWriter.saveResult("Добавление", cars);
                    break;
                case 5:
                    //TODO: Реализовать ThreadSearch
                    System.out.println("Функция в разработке...");
                    break;
                case 0:
                    System.out.println("Завершение работы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
    }
    // Метод заполнения коллекции тремя способами
    private void fillCollection() {

        this.size = sizeOfCollection();

        System.out.println("Способы заполнения:\n1 - из файла\n2 - случайно\n3 - вручную");
        System.out.print("Выберите источник: ");

        int source = scanner.nextInt();

        switch (source) {
            case 1:
                cars = dataFromFile.load(size);
                break;
            case 2:
                cars = randomCarDataInput.load(size);
                break;
            case 3:
                cars = consoleCarDataInput.load(size);
                break;
            default:
                System.out.println("Ошибка выбора источника.");
        }
    }
    // Метод выбора алгоритма сортировки
    private void sortStyle() {
        if (cars == null || cars.isEmpty()) {
            System.out.println("Коллекция пуста. Сортировка невозможна.");
            return;
        }

        System.out.println("Алгоритмы сортировки:\n1 - Обычная сортировка\n2 - сортировка только автомобилей с четной мощностью");
        System.out.print("Выберите алгоритм: ");

        int type = scanner.nextInt();


        // 2. CustomList в массив Car[] для работы алгоритмов сравнения
        Car[] carArray = new Car[size];

        for (int i = 0; i < size; i++) {
            carArray[i] = cars.get(i);
        }

        switch (type) {
            case 1:
                Comparator<Car> selectedComparator = chooseComparator();
                Sort.quickSort(carArray, 0, size - 1, selectedComparator);

                break;
            case 2:
                Comparator<Car> chosenComparator = new CarPowerComparator();
                EvenSort.addCarSort(carArray, chosenComparator);

                break;

            default:
                System.out.println("Ошибка выбора алгоритма сортировки.");
                return;
        }

        // 4. Возвращаем отсортированные элементы назад в CustomList
        for (int i = 0; i < size; i++) {
            cars.set(i, carArray[i]);
        }
    }

    // Вспомогательный метод определения критерия (какой компаратор применить)
    private Comparator<Car> chooseComparator() {
        System.out.println("Критерии сравнения:\n1 - Мощность\n2 - Модель\n3 - Год производства");
        System.out.print("Выберите критерий: ");

        int criterion = scanner.nextInt();
        switch (criterion) {
            case 1:
                return new CarPowerComparator();
            case 2:
                return new CarModelComparator();
            case 3:
                return new CarYearComparator();
            default:
                System.out.println("Некорректный выбор. Применен компаратор по году.");
                return new CarYearComparator();
        }
    }

    // Метод установки размера коллекции
    private int sizeOfCollection() {
        System.out.print("Введите количество элементов коллекции: ");
        return scanner.nextInt();

    }

    // Метод вывода коллекции в консоль
    private void printCollection() {
        if (cars == null || cars.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        System.out.println("--- Элементы коллекции ---");
        for (Car car : cars) { System.out.println(car); }

    }

}









