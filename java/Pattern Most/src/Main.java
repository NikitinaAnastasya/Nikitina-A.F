import Other.Device;
import Other.Randomizer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();

        Scanner scanner = new Scanner(System.in);

        do {
            Device device = randomizer.random();
            System.out.println("""
                    
                    Выберите действие
                    1. Включить
                    2. Выключить
                    """);
            switch (scanner.nextInt()){
                case 1 -> {
                    System.out.println("Включился ");
                }
                case 2 -> {
                    System.out.println("Выключился ");
                }
                case 3 -> System.exit(0);
                default -> throw new RuntimeException("Нет такой команды");
            }
            device.print();
        }while (true);
    }
}