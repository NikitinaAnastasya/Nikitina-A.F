import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Calculator calculator = new Calculator();
    public void menu(){
        List <Tovar> tovars = new ArrayList<>();

        tovars.add(new Pizza(1, "Гавайская", 3,1));
        tovars.add(new Pizza(2, "Маргарита", 5,1));
        tovars.add(new Pizza(3, "Цезарь", 4,1));
        tovars.add(new Pizza(4, "Пеперони", 6,1));
        tovars.add(new Napitki(5, "Лимонад", 1,1));
        tovars.add(new Napitki(6, "Чай", 7,1));
        tovars.add(new Napitki(7, "Кофе", 1,1));
        tovars.forEach(System.out::println);
        System.out.println("Выберите товар");
        execute(tovars);
    }
    private void  execute (List <Tovar> tovars){
        List <Tovar> listZakaza = new ArrayList<>();
        int a= 0;
        do {
            a = scanner.nextInt();
            for (Tovar tovar : tovars) {
                    if (a == tovar.getId()) {
                        listZakaza.add(new Tovar(tovar.getId(), tovar.getName(), tovar.getCena(), tovar.getWid(),1));
                    }
                }
            }
            while (a != 0);


        System.out.println("Чек");

        System.out.println("Сумма заказа = " + calculator.calc(listZakaza));
    }








}
