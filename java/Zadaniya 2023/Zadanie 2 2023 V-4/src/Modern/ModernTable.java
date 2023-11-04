package Modern;

import Interface.Table;

public class ModernTable implements Table {
    @Override
    public void create() {
        System.out.println("Создание стола для современного интерьера");
    }
}
