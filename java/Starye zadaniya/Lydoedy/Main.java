import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Red red = new Red();
        Green green = new Green();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой вы вид?");
        System.out.println("1.Красный \n 2.Зеленый");
        int a= scanner.nextInt();
        if( a == 1){
            red.day();
        }
        else {
            green.day();
        }
    }

    }
