package com.spring.array;

/**
 * Created by jhd on 18/5/7.
 */
public class Array<T> {

    private T[] data;
    private int size;

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is illegal");
        }
        return data[index];
    }

    void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Index is illegal");
        }
        data[index] = e;
    }

    public void addLast(T e) {
        add(size, e);
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    //无效的，返回-1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Require index>=0&& index<=size");
        }
        if (index == data.length) {
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("data size is %d,data capacity is %d", size, data.length));
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        return sb.toString();
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
