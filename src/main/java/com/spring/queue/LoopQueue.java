package com.spring.queue;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by jhd on 18/5/29.
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int tail;
    private int front;
    private int size;


    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        tail = 0;
        front = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void equeue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        } else {
            data[tail] = e;
            tail = (tail + 1) % data.length;
        }
    }

    private void resize(int capacity) {
        E[] datas = (E[]) new Object[capacity + 1];

        for (int i = 0; i < size; i++) {
            datas[i] = data[(i + front) / data.length];
        }
        data = datas;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cann't dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cann't dequeue from an empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue:size=%d,capcaity=%d", size, getCapacity()));
        res.append("front[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]tail");
        return res.toString();
    }
}
