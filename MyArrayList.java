package com.company;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int size;

    public MyArrayList() {
        this.arr = new Object[5];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object item) {
        if (size == arr.length) {
            increaseBuffer();
        }
        arr[size++] = item;
    }

    private void increaseBuffer() {
        Object[] newArr = Arrays.copyOf(arr, arr.length * 2);
        arr = newArr;
    }

    @Override
    public void add(Object item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (size == arr.length) {
            increaseBuffer();
        }

        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }

    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        T temp = (T) arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        arr[--size] = null; // Set the last element to null to avoid memory leak
        return temp;
    }

    @Override
    public void clear() {
        this.arr = new Object[5];
        this.size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        Arrays.sort(arr, 0, size);
    }
}
