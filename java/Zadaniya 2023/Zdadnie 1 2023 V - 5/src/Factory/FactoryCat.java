package Factory;

import Essence.Animal;

import java.util.Scanner;

public class FactoryCat implements FactoryAnimals{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void print(Animal animal) {
        System.out.println("Меня зовут "+animal.getName()+". Я "+ animal.getFloor()+
                ".  Я передвигаюсь " + animal.getMove() + ". Я питаюсь "+animal.getNutrition());
    }

    @Override
    public void move(Animal animal) {
        String act;
        System.out.println("""
                1. Бежать
                2. Стоять
                3. Лежать
                """);
        switch ( scanner.nextInt() ){
            case 1 -> act = "Бежать";
            case 2 -> act = "Стоять";
            case 3 -> act = "Лежать";
            default -> throw new RuntimeException("Нет такого действия!");
        }
        animal.setMove(act);
        System.out.println(animal.getName() +" "+  animal.getMove());
    }
}
