package view;

import history.Log;
import model.*;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Tokenizer tokenizer = new Tokenizer();
    Log log = new Log();


    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("1. Вывести историю");
        System.out.println("2. Ввести пример");
        System.out.println("3. Выход");

        switch (scanner.nextInt()){
            case 1 -> {
                log.readFile();
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

        String rezult = String.valueOf(calculator.calculate());
        System.out.println(primer + " = " + rezult);

        log.writFile(primer,rezult);

        menu();
    }


}
