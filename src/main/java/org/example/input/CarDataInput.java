package org.example.input;

import org.example.list.CustomList;
import org.example.model.Car;

public interface CarDataInput {

    CustomList<Car> load(int count);
}
