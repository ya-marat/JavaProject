package org.example.list;

import java.util.Iterator;
import java.util.Objects;

public class CustomList<T> implements Iterable<T> {

    private final int DEFAULT_SIZE = 10;

    private Object[] elements;
    private int size;

    public CustomList() {
        elements = new Object[DEFAULT_SIZE];
    }

    public void add(T element) {
        if (size == elements.length) {
            resize();
        }

        elements[size++] = element;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        elements = new Object[DEFAULT_SIZE];
        size = 0;
    }

    private void resize() {
        Object[] newData = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newData, 0, elements.length);
        elements = newData;
    }

    private void checkIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return (T) elements[currentIndex++];
            }
        };
    }

    public String toString() {
        StringBuilder list = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) list.append(", ");
            list.append(elements[i]);
        }
        return list.append("]").toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (this.getClass() != obj.getClass()) return false;

        CustomList<T> other = (CustomList<T>) obj;

        if (this.size() != other.size()) return false;

        Iterator<T> thisIter = this.iterator();
        Iterator<T> otherIter = other.iterator();

        while (thisIter.hasNext()) {
            T thisElement = thisIter.next();
            Object otherElement = otherIter.next();
            if (!Objects.equals(thisElement, otherElement)) {
                return false;
            }
        }
        return true;
    }
}

