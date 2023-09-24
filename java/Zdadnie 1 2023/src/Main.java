import Essence.Animal;
import Factory.FactoryAnimals;
import Factory.FactoryCat;
import Factory.FactoryDog;
import Factory.FactoryParrot;

import java.util.Scanner;

public class Main {
    private static Animal dog = new Animal("Собака", "Хатико", " мальчик", null, " мясо");
    private static Animal cat = new Animal("Кошка", "Лиза", " девочка", null, " корм");
    private static Animal parrot = new Animal("Попугай", "Кеша", " мальчик", null, " семечками");
    private static Animal animal = null;
    private static FactoryAnimals factoryAnimals;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("""
                Выберите животное:
                1. Собака
                2. Кошка
                3. Попугай
                """);

        factoryAnimals = start(scanner.nextInt());
        System.out.println("""
                Действие животного
                1. Представление животного
                2. Управление животным
                """);
        action(scanner.nextInt());

    }
    private static FactoryAnimals start (  int a ){
        if (a == 1){
            animal = dog;
            return new FactoryDog();
        } else if (a == 2) {
            animal = cat;
            return new FactoryCat();
        } else if (a == 3) {
            animal = parrot;
            return new FactoryParrot();
        }else {
            throw new RuntimeException("Нет такого животного!!!!!!");
        }
    }
    private static void action (int s){
        switch (s){
            case 1 -> factoryAnimals.print(animal);
            case 2 -> factoryAnimals.move(animal);
            default -> throw new RuntimeException("Нет действия");
        }
    }


}