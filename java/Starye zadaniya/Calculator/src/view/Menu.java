package view;

import history.Log;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    Scanner scanner = new Scanner(System.in);
    Tokenizer tokenizer = new Tokenizer();
    Log log = new Log();

    ArrayList<String> startLog = new ArrayList<>(); // нынешняя история
    ArrayList<String> lastStart = new ArrayList<>(); // история прошлой сессии
    ArrayList<String> fullLog = new ArrayList<>(); // история всех сессий
    ArrayList<String> select = new ArrayList<>(); // список отдельных уравнений

    public void menu(){
        System.out.println("--- MENU ---");
        System.out.println("1. Вывести историю");
        System.out.println("2. Ввести пример");
        System.out.println("3. Сохранение");
        System.out.println("0. Выход");

        switch (scanner.nextInt()){
            case 1 -> history();
            case 2 -> start();
            case 3 -> saveMenu();
            case 0 -> {
                log.writeLastStart(startLog);
                System.exit(0);
            }
        }
    }

    public void saveMenu(){
        System.out.println("""
                --- SAVE MENU ---
                1. Сохранить всю сессию
                2. Сохранить отдельное уровнение
                0. Назад
                """);

        switch (scanner.nextInt()){
            case 1 -> saveCase(startLog);
            case 2 -> selectCase();
            case 0 -> menu();
        }
    }
    public void selectCase(){
        ArrayList<Integer> id = new ArrayList<>();

        ArrayList<String> last = log.readLastStart();

        System.out.println("""
                Из какой истории хотите выбрать уравнения?
                1. Из нынешней
                2. Из прошедшей
                3. Сохранить выбранное
                0. Назад""");

        switch (scanner.nextInt()){
            case 1 -> {
                for(int i = 0;i<startLog.size();i++){
                    System.out.println((i+1) + " -> " + startLog.get(i));
                }
                System.out.println("Выберите уровнение которое хотите отдельно сохранить!\n" +
                        "Чтобы закончить выбор нажмите 0");
                int s;
                do{
                    s = scanner.nextInt();
                    id.add(s-1);

                }while (s >0);

                for(int d : id){
                    for (int i = 0; i<startLog.size();i++){
                        if (d == i){
                            select.add(startLog.get(i));
                        }
                    }
                }
                selectCase();
            }
            case 2 ->{
                for(int i = 0;i<last.size();i++){
                    System.out.println((i+1) + " -> " + last.get(i));
                }
                System.out.println("Выберите уровнение которое хотите отдельно сохранить!\n" +
                        "Чтобы закончить выбор нажмите 0");
                int s;
                do{
                    s = scanner.nextInt();
                    id.add(s-1);

                }while (s >0);

                for(int d : id){
                    for (int i = 0; i<last.size();i++){
                        if (d == i){
                            select.add(last.get(i));
                        }
                    }
                }
                selectCase();
            }
            case 3 -> {
                saveCase(select);
                select.clear();
            }
            case 0 -> saveMenu();

        }
    }
    public void saveCase(ArrayList<String> lg){
            System.out.println("""
                    --- SAVE ---
                    1. Сохранить в общий файл
                    2. Сохранить в отдельный файл
                    """);

            switch (scanner.nextInt()){
                case 1 -> {
                    log.writeFile(lg, null,null);
                    menu();
                }
                case 2 -> {
                    System.out.println("Введите путь");
                    String line = scanner.next();
                    System.out.println("Введите название файла");
                    String name = scanner.next();
                    log.writeFileName(line,name + ".txt",lg );
                    menu();
                }
            }
    }

    public void history(){

        System.out.println("""
                1. Прошлая сессия\s
                2. Нынешная сессия
                5. Общая история""");

        switch (scanner.nextInt()){
            case 1 -> {
                lastStart = log.readLastStart();
                for(int i = 0; i<lastStart.size();i++){
                    System.out.println( (i+1) + " -> " + lastStart.get(i));
                }
                menu();
            }
            case 2 -> {
                for(int i = 0; i< startLog.size(); i++){
                    System.out.println( (i+1) + " -> " + startLog.get(i));
                }
                menu();
            }
            case 5 -> {
                fullLog = log.readFile();
                for(int i = 0; i<fullLog.size();i++){
                    System.out.println( (i+1) + " -> " + fullLog.get(i));
                }
                menu();
            }
        }

    }
    public void start(){
        System.out.println("Введите пример:");
        String primer = scanner.next();

        Calculator calculator = new Calculator(tokenizer.tokenizer(primer));

        String rezult = String.valueOf(calculator.calculate());
        System.out.println(primer + " = " + rezult);

        startLog.add(primer + " = " + rezult);

        menu();
    }

}
