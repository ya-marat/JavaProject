package org.example.list;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.Objects;

public class CustomList<T> extends AbstractList<T> {

    private final int DEFAULT_SIZE = 10;

    private Object[] elements;
    private int size;

    public CustomList() {
        elements = new Object[DEFAULT_SIZE];
    }

    public CustomList(int size) {

        if (size <= 0) {
            throw new RuntimeException("Size cannot be negative or zero");
        }

        elements = new Object[size];
    }

    @Override
    public boolean add(T element) {
        if (size == elements.length) {
            resize();
        }

        elements[size++] = element;
        return true;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
        return element;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;
        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
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
