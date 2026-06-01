package org.example.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final int power;
    private final String model;
    private final int year;

    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    public int getPower() { return power; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    // Базовая сортировка по всем 3 полям сразу
    @Override
    public int compareTo(Car other) {
        int idCompare = Integer.compare(this.power, other.power);
        if (idCompare != 0) {
            return idCompare;
        }

        int nameCompare = this.model.compareTo(other.model);
        if (nameCompare != 0) {
            return nameCompare;
        }

        return Integer.compare(this.year, other.year);
    }

    @Override
    public String toString() {
        return String.format("Product{power=%d, model='%s', year=%d}", power, model, year);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Car))
            return false;

        Car car = (Car) other;
        return power == car.power  &&
                Objects.equals(model, car.model) &&
                year == car.year;
    }

    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            validate();
            return new Car(this);
        }

        private void validate() {
            if (power <= 0) throw new IllegalArgumentException("Мощность должена быть больше 0");
            if (model == null || model.trim().isEmpty()) throw new IllegalArgumentException("Модель не заполнена");
            if (year < 0) throw new IllegalArgumentException("Год выпуска отрицательный");
        }
    }
}
