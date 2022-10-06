import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();

    }
    private static void menu(){
        Scanner scanner= new Scanner(System.in);
        DataBase db= new DataBase();
        cikl:
        while (true){
            System.out.println();
            System.out.println("1.Отдел ");
            System.out.println("2.Товары ");
            System.out.println("3.Списки ");
            System.out.println("4.Выход ");
            int otvet= scanner.nextInt();
            switch (otvet){
                case 1:
                    System.out.println("1. Добавить"+ "\n"+"2.Удалить"+"\n"+"3. Редактировать");
                    int r= scanner.nextInt();
                    if (r== 1){
                    db.addOtdel(db.newOtdel());
                    }
                    if (r==2){
                        db.showOtdel();
                        db.deleteOtdel();
                    }
                    if (r==3){
                        db.showOtdel();
                        db.changeOtdel();
                    }
                    break ;
                case 2:
                    System.out.println("1. Добавить"+"\n"+"2.Удалить"+"\n"+"3. Редактировать");
                    int y= scanner.nextInt();
                    if (y== 1){
                        db.addTovar(db.newTovar());
                    }
                    if (y==2){
                        db.showTovar();
                        db.deleteTovar();
                    }
                    if (y==3){
                        db.showTovar();
                        db.changeTovar();
                    }
                    break ;

                case 3:
                    System.out.println("1.Отдел"+"\n" +"2.Товары"+"\n"+"3.Отделы и товары\n" +"4.Все товары по отделам");
                    int s= scanner.nextInt();
                    if (s==1){
                    db.showOtdel();
                    }
                    if (s==2){
                    db.showTovar();
                    }
                    if (s==3){
                    db.showOtdel();
                    db.showTovar();
                    }
                    if(s==4){
                        db.showVsePoOtdelam();

                    }
                    break;
                default:
                    break cikl;

            }
        }
    }
}

