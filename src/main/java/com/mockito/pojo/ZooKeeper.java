package com.mockito.pojo;

public class ZooKeeper {

    private String name;

    public ZooKeeper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ZooKeeper{" +
                "name='" + name + '\'' +
                '}';
    }
}
