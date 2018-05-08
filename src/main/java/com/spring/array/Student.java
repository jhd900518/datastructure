package com.spring.array;

/**
 * Created by jhd on 18/5/8.
 */
public class Student {

    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("id=" + id);
        sb.append(", ");
        sb.append("name=" + name);
        sb.append("]");
        return sb.toString();
    }
}
