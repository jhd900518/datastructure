package com.spring.stack;

/**
 * Created by jhd on 18/5/8.
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peep();

    int getSize();

    boolean isEmpty();
}
