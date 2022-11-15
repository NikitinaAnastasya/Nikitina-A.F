package ru.vsuet.sample.domain;

import java.util.ArrayList;
import java.util.List;

public class Box {

    private Long id;
    private String name;

    private List<Fruit> fruits;

    public Box(Long id, String name) {
        this.id = id;
        this.name = name;
        this.fruits = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }
}
