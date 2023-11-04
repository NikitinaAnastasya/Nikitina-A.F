package Minimal;

import Interface.Closet;

public class MinimalCloset implements Closet {
    @Override
    public void create() {
        System.out.println("Создание шкафа для минималистичного интерьера");
    }
}
