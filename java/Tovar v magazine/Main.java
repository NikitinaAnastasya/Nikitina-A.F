package test;

import java.util.Scanner;

public class Main {
    private static DataBase db= new DataBase();

    public static void main(String[] args) {
        db.loading();
        menu();

    }
    private static void menu(){
        Scanner scanner= new Scanner(System.in);

        cikl:
        while (true){
            System.out.println();
            System.out.println("1.Отдел ");
            System.out.println("2.Товары ");
            System.out.println("3.Поставщик");
            System.out.println("4.Продавцы ");
            System.out.println("5.Покупатели");
            System.out.println("6.Склад");
            System.out.println("7.Списки ");
            System.out.println("0.Выход ");
            int otvet= scanner.nextInt();
            switch (otvet){
                //отделы
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
                    //Товары
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
                    //поставщики
                case 3:
                    System.out.println("1.Добавить\n 2. Удалить \n 3. Приход \n 4. Редактировать");
                    int x=scanner.nextInt();
                    if(x==1){
                        db.addPostavchik(db.newPostavchik());
                    }
                    if(x==2){

                        db.deletePostavchik();
                    }
                    if (x==3){
                        db.prihod();
                    }
                    if(x==4){
                        db.showIdPostav();
                        db.changePostavchik();
                    }

                    break ;
                    //продавцы
                case 4:
                    System.out.println("1.Добавить 2.Удалить 3.Редактировать");
                    int q =scanner.nextInt();
                    if (q ==1){
                        db.addProdavec(db.newProdavec());
                    }
                    if (q ==2){
                        db.showProdavec();
                        db.deleteProdavec();
                    }
                    if (q ==3){
                        db.showProdavec();
                        db.changeProdavec();
                    }
                    break ;
                        //покупатели
                case 5:
                    System.out.println("1. Добавить 2.Редактировать");
                    int f= scanner.nextInt();
                    if(f==1){
                        db.addPokypatel(db.newPokypatel());
                    }
                    if(f==2){
                        db.changePokypatel();
                    }
                    break ;

                case 7:
                    System.out.println("1.Отдел"+"\n" +"2.Товары"+"\n"+"3.Отделы и товары\n" +"4.Все товары по отделам\n"
                            +"5.Продавцы"+"\n" +"6.Продавцы в отделах"+"\n"+"7.Покупатели\n" +"8.Поставщики\n"
                            +"9.Полный список отдел продавец товар\n"+"10.Склад");
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
                    if(s==5){
                        db.showProdavec();
                    }
                    if(s==6){
                        db.showProdVOtdel();
                    }
                    if(s==7){
                        db.showPokypatel();
                    }
                    if (s==8){
                        db.showPostav();
                    }
                    if(s==9){
                        db.showTovarProdVOtdel();
                    }
                    if(s==10){
                        db.showSklad();
                    }
                    break;
                default:
                    db.save();
                    break cikl;

            }
        }
    }
}

