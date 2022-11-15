package ru.vsuet.sample.repository;

import java.util.List;

public interface Repository<T> {

    T find(Long id);
    void save(T source);
    void remove(T target);
    List<T> list();
}
