package Modern;

import Interface.Closet;

public class ModernCloset implements Closet {
    @Override
    public void create() {
        System.out.println("Создание шкафа для современного интерьера");
    }
}
