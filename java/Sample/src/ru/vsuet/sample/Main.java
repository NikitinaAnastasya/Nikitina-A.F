package ru.vsuet.sample;

import ru.vsuet.sample.domain.Box;
import ru.vsuet.sample.repository.BoxRepository;
import ru.vsuet.sample.repository.DataBaseConnector;
import ru.vsuet.sample.repository.Repository;
import ru.vsuet.sample.service.BoxService;
import ru.vsuet.sample.service.Service;
import ru.vsuet.sample.view.Menu;

public class Main {
    public static void main(String[] args) {

        DataBaseConnector connector = new DataBaseConnector();

        Repository<Box> repository = new BoxRepository(connector);
        Service<Box> boxService = new BoxService(repository);

        Menu menu = new Menu(boxService);
        while (true) {
            menu.draw();
        }
    }
}