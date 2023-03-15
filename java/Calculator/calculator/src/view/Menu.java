package view;

import conteiner.Token;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Tokenizer tokenizer = new Tokenizer();


    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("1. Вывести историю");
        System.out.println("2. Ввести пример");
        System.out.println("3. Выход");

        switch (scanner.nextInt()){
            case 1 -> {
                System.out.println("В РАЗРАБОТКЕ") ;
                menu();
            }
            case 2 -> start();
            case 3 -> System.exit(0);

        }

    }
    public void start(){
        System.out.println("Введите пример:");
        String primer = scanner.next();

        Calculator calculator = new Calculator(tokenizer.tokenizer(primer));
        System.out.println(primer + " = " + calculator.calculate());

        menu();
    }


}
