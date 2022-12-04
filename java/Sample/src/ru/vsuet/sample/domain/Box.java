package ru.vsuet.sample.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box {

    private Long id;
    private String name;

    private List<Fruit> fruits;

    public Box(Long id, String name) {
        this.id = id;
        this.name = name;
        this.fruits = new ArrayList<>();
    }

    public Box(Long id, String name, List<Fruit> fruits) {
        this(id, name);
        this.fruits = fruits;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Objects.equals(id, box.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fruits=" + fruits +
                '}';
    }
}
