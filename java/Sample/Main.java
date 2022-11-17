package ru.vsuet.sample;

import ru.vsuet.sample.domain.Box;
import ru.vsuet.sample.repository.InMemoryBoxRepository;
import ru.vsuet.sample.repository.Repository;
import ru.vsuet.sample.service.BoxService;
import ru.vsuet.sample.service.Service;
import ru.vsuet.sample.view.Menu;

public class Main {
    public static void main(String[] args) {
        Repository<Box> repository = new InMemoryBoxRepository();
        Service<Box> boxService = new BoxService(repository);

        Menu menu = new Menu(boxService);
        while (true) {
            menu.draw();
        }
    }
}