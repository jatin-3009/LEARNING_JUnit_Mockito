package com.mockito.service;

import com.mockito.pojo.ZooKeeper;

public class Animal {

    private ZooKeeper zooKeeper;
    public int age;

    public Animal(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }
}
