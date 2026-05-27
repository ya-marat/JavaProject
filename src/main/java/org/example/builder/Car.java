package org.example.builder;

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

    @Override
    public String toString() {
        return String.format("Car{power=%d, model='%s', year=%d}", power, model, year);
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
            //ToDo DataValidator.isValid(power,model,year);
            return new Car(this);
        }
    }
}
