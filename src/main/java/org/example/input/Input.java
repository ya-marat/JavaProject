package org.example.input;

import org.example.list.CustomList;
import org.example.model.Car;

import java.util.List;

public interface Input<T> {

    CustomList<T> load(int count);
}
