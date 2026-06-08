package org.example.util;


import org.example.list.CustomList;
import org.example.model.Car;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileReportWriter {
    private static final String DEFAULT_EXPORT_FILE = "src/main/java/org/example/report_history.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void saveResult(String operationType, CustomList<Car> cars) {
        Path path = Paths.get(DEFAULT_EXPORT_FILE);

        // Открываем файл через NIO в режиме дозаписи (APPEND).
        // Если файла нет, он автоматически создастся (CREATE).
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            writer.write("========================================\n");
            writer.write(String.format("[%s] Операция: %s\n", LocalDateTime.now().format(FORMATTER), operationType));
            writer.write("========================================\n");

            if (cars == null || cars.size() == 0) {
                writer.write("Нет данных для записи.\n");
            } else {
                for (Car c : cars) {
                    if (c != null) {
                        writer.write(c.toString() + "\n");
                    }
                }
            }
            writer.write("\n");
            System.out.println("Результаты успешно добавлены (NIO) в файл: " + DEFAULT_EXPORT_FILE);

        } catch (IOException e) {
            System.out.println("Ошибка NIO при записи отчета: " + e.getMessage());
        }
    }
}
