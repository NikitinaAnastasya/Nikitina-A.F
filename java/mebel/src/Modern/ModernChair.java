package Modern;

import Interface.Chair;

public class ModernChair implements Chair {
    @Override
    public void create() {
        System.out.println("Создание стула для современного интерьера");
    }
}
