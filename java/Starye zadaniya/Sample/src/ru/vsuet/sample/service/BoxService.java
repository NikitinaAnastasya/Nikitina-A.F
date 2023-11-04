package ru.vsuet.sample.service;

import ru.vsuet.sample.domain.Box;
import ru.vsuet.sample.repository.Repository;

import java.util.List;

public class BoxService implements Service<Box> {

    private final Repository<Box> repository;

    public BoxService(Repository<Box> repository) {
        this.repository = repository;
    }

    @Override
    public Box getById(Long id) {
        return repository.find(id);
    }

    @Override
    public List<Box> getAll() {
        return repository.list();
    }
}
