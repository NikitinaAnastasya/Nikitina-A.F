package Factory;

import Essence.Animal;

import java.util.Scanner;

public class FactoryParrot implements FactoryAnimals{
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
                1. Лететь
                2. Сидеть
                3. Спать
                """);
        switch ( scanner.nextInt() ){
            case 1 -> act = "Лететь";
            case 2 -> act = "Сидеть";
            case 3 -> act = "Спать";
            default -> throw new RuntimeException("Нет такого действия!");
        }
        animal.setMove(act);
        System.out.println( animal.getName() + " "+ animal.getMove());
    }
}
