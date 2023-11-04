import Interface.Observer;

import java.util.List;

public class Patient implements Observer {
    String name;

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public void handEvent(List<String> Tests) {
        System.out.println(name + "Обновление списка анализов" + Tests);

    }
}
