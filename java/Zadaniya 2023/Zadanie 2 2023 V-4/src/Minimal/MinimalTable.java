package Minimal;

import Interface.Table;

public class MinimalTable implements Table {
    @Override
    public void create() {
        System.out.println("Создание стола для минималистичного интерьера");
    }
}
