package test.view;

import test.Service.Service;
import test.Service.ServiceOtdel;
import test.Service.ServiceSklad;
import test.Service.ServiceTovar;
import test.domain.Otdel;
import test.domain.Tovar;
import test.repository.OtdelRepository;
import test.repository.SkladRepository;
import test.repository.TovarRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class OtdelMenu {
    Scanner scanner = new Scanner(System.in);
    private final Service<Otdel> otdelService = new ServiceOtdel(new OtdelRepository());
    private final Service<Tovar> tovarService = new ServiceTovar(new TovarRepository());
    private final Service<Tovar> skladService = new ServiceSklad(new SkladRepository());
    private  Menu menu;

    public OtdelMenu(Menu menu) {
        this.menu=menu;
    }


    void drawOtdel() throws SQLException {
        System.out.println("---Отделы----");
        System.out.println("1.Добавить");
        System.out.println("2.Удалить");
        System.out.println("3.Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1-> newOtdel();
            case 2-> deletOtdel();
            case 3-> changeOtdel();
            case 0 -> menu.draw();
        }

    }
    private void  newOtdel() throws SQLException {
        System.out.println(" Введите данные отдела: ");
        System.out.print("Название : ");
        String name= scanner.next();
        System.out.println("Введите начало работы: ");
        int nch= scanner.nextInt();
        int nmin= scanner.nextInt();
        System.out.println("Введите конец работы");
        int kch= scanner.nextInt();
        int kmin = scanner.nextInt();

        Otdel otdel= new Otdel(null, name,nch, nmin, kch, kmin );
        otdelService.save(otdel);
    }
    private void deletOtdel() throws SQLException {
        drawListOtdel();
        System.out.println(" Выберите отдел, который надо удалить ");
        Long id = scanner.nextLong();

        Otdel otdel= otdelService.find(id);
        List<Tovar> tovarList = tovarService.getListPoId(id);

        for (Tovar tovar : tovarList) {
            Tovar tovar1 = skladService.find( tovar.getId() );
            tovar1.setKolvo( tovar1.getKolvo() + tovar.getKolvo() );
            skladService.update(tovar1);
        }

        otdelService.delete(otdel);
    }
    void changeOtdel() throws SQLException {
        drawListOtdel();
        System.out.println("Выберите отдел, который надо изменить");
        Long id =scanner.nextLong();

        Otdel otdel = otdelService.find(id);

        System.out.println("Что хотите изменить?");
        System.out.println("1. Название");
        System.out.println("2. Начало работы");
        System.out.println("3. Конец работы");
        System.out.println("4. Товар в отделе ");
        System.out.println("5. Назад");

        switch (scanner.nextInt()){
            case 1-> {
                System.out.println(" Введите новое название :");
                otdel.setName(scanner.next());
            }
            case 2->{
                System.out.println(" Введите новое время начала работы");
                otdel.setNch(scanner.nextInt());
                System.out.print(" : ");
                otdel.setNmin(scanner.nextInt());
            }
            case 3 ->{
                System.out.println("Введите новое время конца работы ");
                otdel.setKch(scanner.nextInt());
                System.out.print(" : ");
                otdel.setKmin(scanner.nextInt());
            }
            case 4->{
                System.out.println("1. Добавить в отдел");
                System.out.println("2. Удалить из отдела ");
                System.out.println("0. Назад");
                switch (scanner.nextInt()){
                    case 1->{
                        skladService.getListNoId().forEach(System.out::println);
                        System.out.println("Выберите какой товар добавить в этот отдел: ");
                        Long id_tovar = scanner.nextLong();
                        Tovar tovar = skladService.find(id_tovar);
                        Tovar tovarOtdel = tovar;
                        int q=0;
                        while (q==0){
                            System.out.println("Количество товара на складе= " + tovar.getKolvo());
                            System.out.println("Введите количество в отделе: ");
                            int s = scanner.nextInt();

                            if (s>tovar.getKolvo()){
                                System.out.println("На складе нет столько товара!!!");
                            }else {
                                q=1;
                                tovar.setKolvo( tovar.getKolvo() - s );
                                tovar.setId_otdel(id);
                                tovarOtdel.setKolvo(s);
                                tovarOtdel.setId_otdel(id);

                                System.out.print("Введите цену на товар: ");
                                tovarOtdel.setCena(  scanner.nextFloat() );
                            }
                        }
                        tovarService.save(tovarOtdel);
                        skladService.update(tovar);
                    }
                    case 2->{
                        skladService.getListPoId(id).forEach(System.out::println);
                        System.out.println("Выберите товар который хотите удалить: ");
                        Long id_tovar = scanner.nextLong();

                        Tovar tovar = tovarService.find(id_tovar);
                        Tovar tovar1 = skladService.find( id_tovar );

                        tovar1.setKolvo( tovar1.getKolvo() + tovar.getKolvo() );
                        skladService.update(tovar1);
                        tovarService.delete(tovar);
                    }
                    case 0->{
                        drawOtdel();
                    }
                }
            }
        }

    }
    void drawListOtdel() throws SQLException {
        System.out.println();
        System.out.println("---Список отделов---");
        otdelService.getAll().forEach(System.out::println);

    }
}
