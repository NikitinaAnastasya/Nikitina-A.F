package Classic;

import Interface.Table;

public class ClassicTable implements Table {
    @Override
    public void create() {
        System.out.println("Создание стола для классического интерьера");
    }
}
