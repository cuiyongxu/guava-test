package com.ijson.groovy.entity

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;

class Client {
    private int id;
    private String name;
    private int age;

    public Client() {}

    public Client(int id, String name, int age) {
        this.id = id
        this.name = name
        this.age = age
    }


    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    int getAge() {
        return age
    }

    void setAge(int age) {
        this.age = age
    }

    public static Client create(int id, String name, int age) {
        return new Client(id, name, age)
    }

    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("id", id)
                .add("name", name)
                .add("age", age).omitNullValues().toString();
    }

    public String toLogString() {
        return Joiner.on('|').useForNull("-")
                .join(id, name, age);
    }

}
