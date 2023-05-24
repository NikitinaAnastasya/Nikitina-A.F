import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zakaz {
    Scanner scanner = new Scanner(System.in);
    Calculator calculator = new Calculator();
    public void zakaz(List<Tovar> tovars){

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
