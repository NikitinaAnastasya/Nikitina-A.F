package Classic;

import Interface.Closet;

public class ClassicCloset implements Closet {
    @Override
    public void create() {
        System.out.println("Создание шкафа для классического интерьера");
    }
}
