import Classic.ClassicFactory;
import Interface.FurnFactory;
import Minimal.MinimalFactory;
import Modern.ModernFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FurnFactory furnFactory = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                    
                    Выберите стиль интерьера
                    1. Классический
                    2. Минимализм
                    3. Современный
                    """);
            switch (scanner.nextInt()){
                case 1 -> furnFactory= new ClassicFactory();
                case 2 -> furnFactory= new MinimalFactory();
                case 3 -> furnFactory= new ModernFactory();
                case 0 -> System.exit(0);
                default -> throw new RuntimeException(" Нет такого стиля интерьера!");
            }
            furnFactory.getChair().create();
            furnFactory.getCloset().create();
            furnFactory.getTable().create();
        }while (true);
    }
}