import java.util.ArrayList;
import java.util.List;

public class Menu {
    public void menu(){
        Zakaz zakaz = new Zakaz();

        List<Tovar> tovars =new ArrayList<>();

        tovars.add(new Pizza(1, "Гавайская", 3,1));
        tovars.add(new Pizza(2, "Маргарита", 5,1));
        tovars.add(new Pizza(3, "Цезарь", 4,1));
        tovars.add(new Pizza(4, "Пеперони", 6,1));
        tovars.add(new Napitki(5, "Лимонад", 1,1));
        tovars.add(new Napitki(6, "Чай", 7,1));
        tovars.add(new Napitki(7, "Кофе", 1,1));

        zakaz.zakaz(tovars);

    }

}
