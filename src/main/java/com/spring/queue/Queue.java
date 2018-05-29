package com.spring.queue;

/**
 * Created by jhd on 18/5/9.
 */
public interface Queue<E> {

    void equeue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
