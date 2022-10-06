import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    Scanner scanner = new Scanner(System.in);
    public List<Otdel> ot = new ArrayList<>();
    private List<Tovar> tov = new ArrayList<>();


    //Отделы
    void addOtdel(Otdel Otdel) {
        ot.add(Otdel);
    }

    void deleteOtdel() {
        System.out.println();
        System.out.println("Введите номер отдела: ");
        int w = scanner.nextInt();
        ot.remove(w);
    }

    void changeOtdel() {
        System.out.println();
        System.out.println("Введите номер отдела, который хотите изменить: ");
        int j = scanner.nextInt();
        System.out.println(ot.get(j));
        System.out.println("Выберете то что хотите изменить : 1. Полностью отдел 2. Название отдела 3.Время работы  ");
        int q = scanner.nextInt();
        if (q == 1) {
            ot.set(j, newOtdel());
        }
        if (q == 2) {
            System.out.println("Введите новое название отдела");
            String e = scanner.next();
            ((Otdel) ot.get(j)).setNazvan(e);
        }
        if (q == 3) {

            System.out.println("Введите новове время работы: ");

            String cr1 = scanner.next();
            String cr11=scanner.next();
            String cr2=scanner.next();
            String cr22=scanner.next();

            chageTimeWork(j,cr1,cr11,cr2,cr22);
        }

    }

    void showOtdel() {
        for (int i = 0; i < ot.size(); i++) {
            System.out.println(i + " " + ot.get(i));
        }
    }

    Otdel newOtdel() {
        System.out.println("Введите название отдела: ");
        String l = scanner.next();
        System.out.println("Введите часы работы : ");
        System.out.println("Начало работы");
        String cr1 = scanner.next();
        String cr11 = scanner.next();
        System.out.println("Конец работы ");
        String cr2 = scanner.next();
        String cr22 = scanner.next();
        Otdel o = new Otdel(l, cr1, cr11, cr2, cr22);
        System.out.println(o);
        return o;
    }

    //Товары
    void addTovar(Tovar Tovar) {
        tov.add(Tovar);
    }

    void deleteTovar() {
        System.out.println();
        System.out.println("Введите номер товара");
        int d = scanner.nextInt();
        tov.remove(d);
    }

    void changeTovar() {
        System.out.println();
        System.out.println("Введите номер товара, который хотите изменить");
        int h = scanner.nextInt();
        System.out.println(tov.get(h));
        System.out.println("Выберете то, что хотите изменить: 1. Полностью товар 2.Название товара 3. Цену товара 4. Отдел");
        int n = scanner.nextInt();
        if (n == 1) {
            tov.set(h, newTovar());
        }
        if (n == 2) {
            System.out.println("Введите новое название товара");
            String v = scanner.next();
            ((Tovar) tov.get(h)).setNaztov(v);
        }
        if (n == 3) {
            System.out.println("Введите новую цену товара");
            float t = scanner.nextFloat();
            ((Tovar) tov.get(h)).setCena(t);
        }
        if (n == 4) {
            System.out.println("Выберете новый отдел");
            showOtdel();
            int z = scanner.nextInt();
            String i = ((Otdel) ot.get(z)).getNazvan();
            ((Tovar) tov.get(h)).setOtdely(i);
        }
    }

    void showTovar() {
        for (int i = 0; i < tov.size(); i++) {
            System.out.println(i + " " + tov.get(i));
        }
    }

    Tovar newTovar() {
        String s = null;
        int y=0;
        System.out.println("Введите название товара: ");
        String l = scanner.next();

        System.out.println("1 Выбрать отдел 2 Создать отдел");
        int r = scanner.nextInt();
        if (r == 1) {
            if (ot.size() != 0) {
                System.out.println("Выберете отдел");
                showOtdel();
                y = scanner.nextInt();
                s = ((Otdel) ot.get(y)).getNazvan();

            } else {
                System.out.println("Список отделов пуст ");
                s = null;
            }
        }
        if (r == 2) {
            addOtdel(newOtdel());
            int t = ot.size() - 1;
            s = ((Otdel) ot.get(t)).getNazvan();
        }
        System.out.println("Введите цену товара : ");
        float w = scanner.nextFloat();

        Tovar o = new Tovar(l, w, s);

        if (s!=null){

            ot.get(y).setTovar(o);
        }
        System.out.println(o);
        return o;
    }

    void showVsePoOtdelam() {
        for(int j=0;j<ot.size();j++){
            System.out.println(((Otdel)ot.get(j)).getNazvan());
            ot.get(j).getTovar();

        }
    }

        //прочие
    void chageTimeWork(int n,String cr1,String cr11,String cr2, String cr22){
        if (cr1!=null){
            ((Otdel)ot.get(n)).setCr1(cr1);
        }
        if (cr11!=null){
            ((Otdel)ot.get(n)).setCr11(cr11);
        }
        if (cr2!=null){
            ((Otdel)ot.get(n)).setCr2(cr2);
        }
        if (cr22!=null){
            ((Otdel)ot.get(n)).setCr22(cr22);
        }

    }





}
