package org.example.input;

import java.util.List;

public interface Input<T> {

    List<T> load();
}
