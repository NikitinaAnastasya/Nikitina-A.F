package ru.vsuet.sample.repository;

import ru.vsuet.sample.domain.Box;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBoxRepository implements Repository<Box> {

    private final List<Box> boxes;

    public InMemoryBoxRepository() {
        this.boxes = Storage.getInstance().boxes;
    }

    @Override
    public Box find(Long id) {
        return boxes.stream()
                .filter(b -> id.equals(b.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Box source) {
        boxes.add(source);
    }

    @Override
    public void remove(Box target) {
        boxes.removeIf(box -> box.getId().equals(target.getId()));
    }

    @Override
    public List<Box> list() {
        return new ArrayList<>(boxes);
    }
}
