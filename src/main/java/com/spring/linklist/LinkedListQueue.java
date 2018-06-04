package com.spring.linklist;

import com.spring.queue.Queue;
import sun.print.CUPSPrinter;

/**
 * Created by jhd on 18/6/3.
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
    }

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void equeue(E e) {
        if (tail == null) {
            tail = new Node(e);
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cann't dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        for (int i = 0; i < size; i++) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        return sb.toString();
    }
}
