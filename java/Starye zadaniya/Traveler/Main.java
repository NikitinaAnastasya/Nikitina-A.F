
import java.util.Random;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {

        start();

    }

    public static void start(){
        System.out.println("Выберите погодные условия: ");
        System.out.println("1 - Дождь \n2 - Снег \n3 - Солнце");
        int pog = scanner.nextInt();
        System.out.println("Сколько денег у путешествинника: ");
        int money = scanner.nextInt();

        Pytehestv pytehestv = new Pytehestv(money,pogoda(pog,money));

        System.out.println(pytehestv);

    }

    public static String pogoda(int a,int money){
        String move = null;
        if (a == 1 || a == 2){
            if (money >=60){
                move = movement( random.nextBoolean() ? 1 : 3 );
            }
            else{
                move = movement(1);
            }
        }
        if (a == 3){
            if (money >= 60){
                move = movement(random.nextInt(3) + 1);
            }
            else{
                move = movement( random.nextBoolean() ? 1 : 2);
            }
        }
        return move;
    }

    public static String movement(int a){

        String move = null;

        if (a == 1){
            move = "Идти пешком";
        }
        if (a == 2){
            move = "Ехать на велосипеде";
        }
        if (a == 3){
            move = "Ехать на автобусе";
        }
        return move;
    }

}