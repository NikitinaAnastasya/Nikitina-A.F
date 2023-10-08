import Adapter.AdapterHD;
import Adapter.AdapterMP3;
import Adapter.AdapterWAV;
import Adapter.AdapterWMV;
import Interface.Actions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Actions actions = null;
        do {
            System.out.println("""
                    
                    Выберите тип файла
                    1. Аудио
                    2. Видео
                    0. Выход
                    """);
            int x = scanner.nextInt();

            switch (x){
                case 1 ->  System.out.println("""
                        
                        1.MP3
                        2.WAV
                        """);
                case 2 -> System.out.println("""
                        
                        1.HD
                        2.WMV
                        """);
                case 0 -> System.exit(0);
                default -> throw new RuntimeException("Нет такого типа файла!") ;
            }

            int y = scanner.nextInt();

            actions = choice(x,y);

            actions.reproduce();
        }while (true);
    }
    public static Actions choice(int x, int y){
        Actions act = null;
        if ( x == 1){
            switch (y){
                case 1 -> act = new AdapterMP3();
                case 2 -> act = new AdapterWAV();
                default -> throw new RuntimeException("Нет такого формата файла!") ;
            }
        }if (x == 2){
            switch (y){
                case 1 -> act = new AdapterHD();
                case 2 -> act = new AdapterWMV();
                default -> throw new RuntimeException("Нет такого формата файла!") ;
            }
        }
        return act;
    }
}