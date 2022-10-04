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
class Otdel{
    String nazvan;
    int cr1;
    String cr11;
    int cr2;
    String cr22;
    Otdel(String nazvan, int cr1, String cr11, int cr2, String cr22){
        this.nazvan=nazvan;
        this.cr1=cr1;
        this.cr11=cr11;
        this.cr2=cr2;
        this.cr22=cr22;
    }

    public void setNazvan(String nazvan) {
        this.nazvan = nazvan;
    }

    public String getNazvan() {
        return nazvan;
    }

    public void setCr1(int cr1) {
        this.cr1 = cr1;
    }

    public int getCr1() {
        return cr1;
    }

    public void setCr11(String cr11) {this.cr11 = cr11;}

    public String getCr11() {return cr11;}

    public void setCr2(int cr2) {
        this.cr2 = cr2;
    }

    public int getCr2() {
        return cr2;
    }

    public void setCr22(String cr22) {this.cr22 = cr22;}

    public String getCr22() {return cr22;}

    @Override
    public String toString() {
        return nazvan+" "+ cr1+":"+cr11+" - "+cr2+":"+cr22;
    }

}
class Tovar{
    String naztov;
    float cena;
    String otdely;
    Tovar(String naztov, float cena, String otdely){
        this.naztov=naztov;
        this.cena=cena;
        this.otdely=otdely;
    }

    public void setNaztov(String naztov) {
        this.naztov = naztov;
    }

    public String getNaztov() {
        return naztov;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public float getCena() {
        return cena;
    }

    public void setOtdely(String otdely) {this.otdely = otdely;}

    public String getOtdely() {return otdely;}

    @Override
    public String toString() {
        return naztov+ " "+ cena+" "+ otdely;
    }

}
class DataBase{
    Scanner scanner=new Scanner(System.in);
    private List<Otdel> ot= new ArrayList<>();
    private List<Tovar> tov = new ArrayList<>();
//Отделы
    void addOtdel(Otdel Otdel){
        ot.add(Otdel);
    }
    void deleteOtdel(){
        System.out.println();
        System.out.println("Введите номер отдела: ");
        int w =scanner.nextInt();
        ot.remove(w);
    }
    void changeOtdel(){
        System.out.println();
        System.out.println("Введите номер отдела, который хотите изменить: ");
        int j=scanner.nextInt();
        System.out.println(ot.get(j));
        System.out.println("Выберете то что хотите изменить : 1. Полностью отдел 2. Название отдела 3.Время работы  ");
        int q= scanner.nextInt();
        if (q== 1){
            ot.set(j, newOtdel());
        }
        if (q==2){
            System.out.println("Введите новое название отдела");
            String e= scanner.next();
            ((Otdel)ot.get(j)).setNazvan(e);
        }
        if (q==3){
            System.out.println("Какое время хотите изменить: 1. Начало работы 2. Конец работы 3. Время работы");
            int b= scanner.nextInt();
            if (b==1){
                System.out.println("Введите время начала работы :");
                System.out.println("Часы и минуты соответсвенно");
                int cr1=scanner.nextInt();
                String cr11=scanner.next();
            }
            if (b== 2){
                System.out.println("Введите время конца работы");
                System.out.println("Часы и минуты соответсвенно");
                int cr2= scanner.nextInt();
                String cr22=scanner.next();

            }
            if (b==3){
                System.out.println("Введите время работы");
                System.out.println(" Начало и конец работы соответственно");
                int cr1=scanner.nextInt();
                String cr11=scanner.next();
                int cr2= scanner.nextInt();
                String cr22=scanner.next();
            }
        }

    }
    void showOtdel(){
        for (int i=0; i<ot.size(); i++){
            System.out.println(i+" "+ ot.get(i));
        }
    }
    Otdel newOtdel(){
        System.out.println("Введите название отдела: ");
        String l =scanner.next();
        System.out.println("Введите часы работы : ");
        System.out.println("Начало работы");
        int cr1= scanner.nextInt();
        String cr11=scanner.next();
        System.out.println("Конец работы ");
        int cr2 = scanner.nextInt();
        String cr22= scanner.next();
        Otdel o= new Otdel(l, cr1,cr11, cr2, cr22);
        System.out.println(o);
        return o;
    }

//Товары
   void addTovar(Tovar Tovar){tov.add(Tovar);}
    void deleteTovar(){
        System.out.println();
        System.out.println("Введите номер товара");
        int d= scanner.nextInt();
        tov. remove(d);
    }
    void changeTovar(){
        System.out.println();
        System.out.println("Введите номер товара, который хотите изменить");
        int h= scanner.nextInt();
        System.out.println(tov.get(h));
        System.out.println("Выберете то, что хотите изменить: 1. Полностью товар 2.Название товара 3. Цену товара 4. Отдел");
        int n= scanner.nextInt();
        if (n==1){
            tov.set(h, newTovar());
        }
        if (n==2){
            System.out.println("Введите новое название товара");
            String v=scanner.next();
            ((Tovar)tov.get(h)).setNaztov(v);
        }
        if (n==3){
            System.out.println("Введите новую цену товара");
            float t = scanner.nextFloat();
            ((Tovar)tov.get(h)).setCena(t);
        }
        if(n==4){
            System.out.println("Выберете новый отдел");
            showOtdel();
            int z=scanner.nextInt();
            String i= ((Otdel)ot.get(z)).getNazvan();
            ((Tovar)tov.get(h)).setOtdely(i);
        }
    }
    void showTovar(){
        for (int i=0; i< tov.size(); i++){
            System.out.println(i+" "+ tov.get(i));
        }
    }
    Tovar newTovar(){
        String s = null;
        System.out.println("Введите название товара: ");
        String l =scanner.next();

        System.out.println("1 Выбрать отдел 2 Создать отдел");
        int r= scanner.nextInt();
        if (r==1){
            if (ot.size()!=0){
            System.out.println("Выберете отдел");
            showOtdel();
            int y=scanner.nextInt();
             s= ((Otdel)ot.get(y)).getNazvan();
            }
            else{
                System.out.println("Список отделов пуст ");
                s= null;
            }
        }
        if (r==2){
            addOtdel(newOtdel());
            int t= ot.size()-1;
            s= ((Otdel)ot.get(t)).getNazvan();
        }
        System.out.println("Введите цену товара : ");
        float w= scanner.nextFloat();
        Tovar o= new Tovar(l,w,s);
        System.out.println(o);
        return o;
    }
    void showVsePoOtdelam(){
        for ( int i=0; i<ot.size();i++){
            System.out.println( ((Otdel)ot.get(i)).getNazvan());
            for( int j=0; j<tov.size(); j++){
                if(((Otdel)ot.get(i)).getNazvan()==((Tovar)tov.get(j)).getOtdely() ){
                    System.out.println(((Tovar)tov.get(j)).getNaztov());
                }
            }
        }
    }



}
