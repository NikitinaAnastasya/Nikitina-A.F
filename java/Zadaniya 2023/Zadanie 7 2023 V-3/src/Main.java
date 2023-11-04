import java.util.Scanner;

public class Main {
    static Scanner scanner =  new Scanner(System.in);
    static CarBuilder builder = new Auto();
    public static void main(String[] args) {
        do {
            System.out.println("""
                    1.Создать
                    0.Выйти
                    """);
            switch (scanner.nextInt()){
                case 1 -> create();
                case 0 -> System.exit(0);
            }
        }while (true);
    }
    public static void create(){
        builder.CarBuilder();
        System.out.println("Введите марку автомобиля");
        builder.buildBrand(scanner.next());
        System.out.println("Введите модель автомобиля");
        builder.buildModel(scanner.next());
        System.out.println("Введите цвет автомобиля");
        builder.buildColor(scanner.next());
        System.out.println(builder.getCar());
    }
}