package com.spring.queue;

import com.spring.array.Array;

/**
 * Created by jhd on 18/5/9.
 */
public class Main {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.equeue(i);
        }
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);
    }

}
