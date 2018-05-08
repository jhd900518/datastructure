package com.spring.array;

/**
 * Created by jhd on 18/5/7.
 */
public class Main {

    public static void main(String[] args) {
        Array<Student> array = new Array(20);
        array.addLast(new Student("1000", "刘备"));
        array.addLast(new Student("1001", "张飞"));
        array.addLast(new Student("1002", "关羽"));
        System.out.println(array);

        array.addFirst(new Student("0009", "汉献帝"));
        System.out.println(array);

        array.removeLast();
        System.out.println(array);
    }
}
