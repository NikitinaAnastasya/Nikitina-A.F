package ru.vsuet.sample.repository;

import ru.vsuet.sample.domain.Box;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static Storage instance;

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    List<Box> boxes;

    private Storage() {
        this.boxes = new ArrayList<>();
        init();
    }

    private void init() {
        Box box1 = new Box(1L, "Box 1");
        Box box2 = new Box(2L, "Box 2");

        boxes.add(box1);
        boxes.add(box2);
    }
}
