package Minimal;

import Interface.Chair;

public class MinimalChair implements Chair {
    @Override
    public void create() {
        System.out.println("Создание стула для минималистичного интерьера");
    }
}
