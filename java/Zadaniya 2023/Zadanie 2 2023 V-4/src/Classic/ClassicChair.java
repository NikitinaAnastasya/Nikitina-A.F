package Classic;

import Interface.Chair;

public class ClassicChair implements Chair {

    @Override
    public void create() {
        System.out.println("Создание стула для классического интерьера");
    }
}
