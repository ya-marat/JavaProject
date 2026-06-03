

package org.example;




import java.util.Scanner;
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
    //private Sort sort = new Sort();



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
                    //TODO: Реализовать, подключить
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

        int size = sizeOfCollection();

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
                System.out.println("Ручной ввод пока не реализован.");
                break;
            default:
                System.out.println("Ошибка выбора источника.");
        }
    }
    // Метод выбора алгоритма сортировки
    private void sortStyle() {
        System.out.println("Алгоритмы сортировки:\n1 - Обычная сортировка\n2 - сортировка только автомобилей с четной мощностью");
        System.out.print("Выберите алгоритм: ");

        int type = scanner.nextInt();

        switch (type) {
            case 1:
                sortCollection();
                break;
            case 2:
                System.out.println("сортировка по четной мощности в разработке...");
                break;

            default:
                System.out.println("Ошибка выбора алгоритма сортировки.");
        }
    }
    // Метод сортировки по одному из полей
    private void sortCollection() {
        System.out.println("Способы сортировки:\n1 - мощность\n2 - модель\n3 - год производства");
        System.out.print("Выберите поле сортировки: ");

        int type = scanner.nextInt();

        switch (type) {
            case 1:
                System.out.println("Здесь должна быть сортировка по мощности.");
                break;
            case 2:
                System.out.println("Здесь должна быть сортировка по модели.");
                break;
            case 3:
                System.out.println("Здесь должна быть сортировка по году производства.");
                break;
            default:
                System.out.println("Ошибка выбора типа сортировки.");
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









