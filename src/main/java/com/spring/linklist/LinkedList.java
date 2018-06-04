package com.spring.linklist;

/**
 * Created by jhd on 18/6/3.
 */
public class LinkedList<E> {

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

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addElement(int index, E e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("index is out of size");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;

    }

    public void addFirst(E e) {
        addElement(0, e);
    }

    public void addLast(E e) {
        addElement(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed,Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed,Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete failed,Illegal index");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return removeElement(0);
    }

    public E removeLast() {
        return removeElement(size - 1);
    }

    public E getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete failed,Illegal index");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        return pre.next.e;
    }

    public E getFirst() {
        return getElement(0);
    }

    public E getLast() {
        return getElement(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
