package org.example.validation;

public class Validator {

    public static boolean isValid(int power, String model, int year) {
        return power > 0 && model != null && !model.trim().isEmpty() && isValidYear(year);
    }

    public static void validate(int power, String model, int year) throws IllegalArgumentException {
        if (!isValid(power, model, year)) {
            throw new IllegalArgumentException(
                    String.format("Неверные данные: мощность=%d, модель='%s', год=%d",
                            power, model, year)
            );
        }
    }

    public static boolean isValidYear(int year) {
        String yearString = String.valueOf(year);
        return year > 0 && yearString.length() == 4;
    }
}
