package ru.vsuet.sample.view;

import ru.vsuet.sample.domain.Box;
import ru.vsuet.sample.service.Service;

import java.util.Scanner;

public class Menu {

    Scanner keyboard = new Scanner(System.in);
    private final Service<Box> boxService;

    public Menu(Service<Box> boxService) {
        this.boxService = boxService;
    }

    public void draw() {
        System.out.println("------ MENU ------");
        System.out.println("1 - objects list");
        System.out.println("2 - object by id");
        System.out.println("9 - Exit");

        execute();
    }

    private void execute() {
        int command = keyboard.nextInt();

        switch (command) {
            case 1 -> drawObjectsList();
            case 2 -> drawSingleObject();
            case 9 -> System.exit(0);
            default -> throw new IllegalArgumentException("No command found");
        }
    }

    private void drawSingleObject() {
        System.out.print("Enter object id: ");
        long id = keyboard.nextLong();
        System.out.println("---- Single object ----");
        Box box = boxService.getById(id);
        System.out.println(box);
    }

    private void drawObjectsList() {
        System.out.println("---- Objects list ----");
        boxService.getAll().forEach(System.out::println);
    }
}
