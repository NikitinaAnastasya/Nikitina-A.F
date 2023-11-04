import Interface.Observed;
import Interface.Observer;
import Tests.TestBlood;
import Tests.TestPCR;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Observer pat = new Patient("Александр");
        Observer pat1 = new Patient("Михаил");

        Observed test1 = new TestBlood();
        Observed test2 = new TestPCR();

        test1.addPatient(pat);
        test2.addPatient(pat1);
        do {
            System.out.println("""
                    
                    1. Кровь
                    2. ПЦР
                    0. Выход
                    """);
            switch (scanner.nextInt()){
                case 1 -> tests(test1);
                case 2 -> tests(test2);
                case 0 -> System.exit(0);
            }
        }while (true);
    }

    public static void tests(Observed test) {
        System.out.println("""
                1. Добавить
                2. Удалить
                
                """);
        switch (scanner.nextInt()){
            case 1 -> test.addTest(scanner.next());
            case 2 -> test.removeTest(scanner.next());
        }

    }
}