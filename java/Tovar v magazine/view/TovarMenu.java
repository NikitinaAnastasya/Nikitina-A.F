package test.view;

import test.Service.Service;
import test.Service.ServicePostavchik;
import test.Service.ServiceSklad;
import test.Service.ServiceTovar;
import test.domain.Postavchik;
import test.domain.Tovar;
import test.repository.PostavchikRepository;
import test.repository.SkladRepository;
import test.repository.TovarRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class TovarMenu {
    Scanner scanner = new Scanner(System.in);

    private Menu menu;
    private OtdelMenu otdelMenu;
    private PostavchikMenu postavchikMenu;

    private final Service<Tovar> tovarService;
    private final Service<Tovar> skladService;
    private final Service<Postavchik> postavchikService=new ServicePostavchik(new PostavchikRepository());

    public TovarMenu(Menu menu, OtdelMenu otdelMenu, PostavchikMenu postavchikMenu,
                     Service<Tovar> skladService,Service<Tovar> tovarService) {
        this.menu=menu;
        this.otdelMenu=otdelMenu;
        this.postavchikMenu=postavchikMenu;
        this.tovarService=tovarService;
        this.skladService=skladService;
    }


    void drawTovar() throws SQLException {
        System.out.println("--- Товар ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");
        int d=scanner.nextInt();
        switch (d){
            case 1->newTovar();
            case 2->deleteTovar();
            case 3->{
                System.out.println();
                System.out.println("1. На складе");
                System.out.println("2. В отделах");
                System.out.println("0. Назад");
                switch (scanner.nextInt()){
                    case 1-> {
                        changeTovarSklad();
                    }
                    case 2->{
                        changeTovar();
                    }
                    case 0->drawTovar();
                }

            }
            case 0 -> menu.draw();
        }
    }
    private void newTovar() throws SQLException {
        System.out.println("1. На склад");
        System.out.println("2. В отдел");
        switch (scanner.nextInt()){
            case 1->{
                System.out.println("Введите данные товара");
                System.out.print("Название: ");
                String name = scanner.next();
                System.out.println("Количество:");
                int kolvo = scanner.nextInt();
                postavchikMenu.drawListPostavchik();
                System.out.println("Выберите поставщика: ");
                Long id_postav = scanner.nextLong();

                Tovar tovar = new Tovar(null,name,0,kolvo, 0L,id_postav);
                skladService.save(tovar);
            }
            case 2-> {
                otdelMenu.drawListOtdel();
                System.out.println("Выберите отдел в который хотите добавить товар: ");
                Long id_otdel = scanner.nextLong();
                skladService.getListPoId(0L).forEach(System.out::println);
                System.out.println("Выберите какой товар хотите добавить в этот отдел: ");
                Long id_tovar = scanner.nextLong();
                Tovar tovar = skladService.find(id_tovar);

                System.out.println("Введите цену на товар(формат: **.**  )");
                float cena = scanner.nextFloat();
                int q=0;
                int kolvo=0;
                while (q==0) {
                    System.out.println("Количество на складе=" + tovar.getKolvo());
                    System.out.print("Введите нужное количество в отделе= ");
                    kolvo=scanner.nextInt();
                    if(kolvo<=tovar.getKolvo()){
                        q+=1;
                    }
                }
                tovar.setKolvo(tovar.getKolvo() - kolvo );
                tovar.setId_otdel(id_otdel);
                skladService.update( tovar );
                tovarService.save(new Tovar(id_tovar,tovar.getNaztov(),cena,kolvo,id_otdel,tovar.getId_postav()));
            }
        }

    }
    private void deleteTovar() throws SQLException {
        skladService.getAll().forEach(System.out::println);
        System.out.print("Выберите товар который надо удалить:");
        Long id = scanner.nextLong();

        Tovar tovar = skladService.find(id);

        skladService.delete(tovar);
    }
    private void changeTovar() throws SQLException {
        drawListTovar();
        System.out.print("Выберите товар который надо изменить:");
        Long id = scanner.nextLong();

        Tovar tovar = tovarService.find(id);
        Tovar tovarSklad = skladService.find(id);

        System.out.println("Что хотите изменить?");
        System.out.println("1. Цена");
        System.out.println("2. Количество в отледе");
        System.out.println();
        System.out.println("9. Выйти");
        System.out.println("0. Сохранить и выйти");

        int d=scanner.nextInt();
        switch (d){
            case 1->{
                System.out.print("Напишите новую цену:");
                tovar.setCena( scanner.nextFloat() );
            }
            case 2 ->{
                System.out.println("1. Увеличить ");
                System.out.println("2. Уменьшить");
                System.out.println("0. Назад");
                switch (scanner.nextInt()){
                    case 1->{
                        int q=0;
                        while (q==0) {
                            System.out.println("Количество товара на складе= " + tovarSklad.getKolvo());
                            System.out.println("Количество товара в отделе= " + tovar.getKolvo());
                            System.out.print("Введите сколько товара добавить в отдел= ");
                            int s = scanner.nextInt();
                            if (tovarSklad.getKolvo()>s) {
                                tovarSklad.setKolvo(tovarSklad.getKolvo() - s);
                                tovar.setKolvo(tovar.getKolvo() + s);
                                q=1;
                                skladService.update(tovarSklad);
                                tovarService.update(tovar);
                                System.out.println("Выполнено");
                            }else {
                                System.out.println("Столько товара нет на складе!!!");
                            }
                        }
                    }
                    case 2->{
                        int q=0;
                        while (q==0) {
                            System.out.print("Количество товара на складе= " + tovarSklad.getKolvo());
                            System.out.print("Количество товара в отделе= " + tovar.getKolvo());
                            System.out.print("Введите сколько товара убрать из отдела= ");
                            int s = scanner.nextInt();
                            if (tovar.getKolvo() > s) {
                                tovarSklad.setKolvo(tovarSklad.getKolvo() + s);
                                tovar.setKolvo(tovar.getKolvo() - s);
                                q=1;
                            }else {
                                System.out.println("В отделе не хватает товара!!!");
                            }
                        }
                    }

                    case 0->otdelMenu.changeOtdel();
                }
            }
            case 9->{
                menu.draw();
            }
            case 0-> {
                skladService.update(tovarSklad);
                tovarService.update(tovar);
                menu.draw();
            }
        }
    }
    private void changeTovarSklad() throws SQLException {
        System.out.println("--- Товар на складе ---");
        skladService.getAll().forEach(System.out::println);
        System.out.print("Выберите товар: ");
        Long id_tovar = scanner.nextLong();

        Tovar tovarSklad = skladService.find(id_tovar);
        Tovar tovar = tovarService.find(id_tovar);

        if (tovar != null) {

            System.out.println("--- Изменение товара на складе ---");
            System.out.println("Что хотите изменить?");
            System.out.println("1. Название");
            System.out.println("2. Количество на складе");
            System.out.println("3. Поставщик");
            System.out.println("9. Назад ");
            System.out.println("0. Сохранить и выйти ");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Введите новое название: ");
                    String name = scanner.next();
                    tovar.setNaztov(name);
                    tovarSklad.setNaztov(name);
                }
                case 2 -> {
                    System.out.println("Количество товара на складе: "+tovarSklad.getKolvo());
                    System.out.print("Введите новое количество: ");
                    tovarSklad.setKolvo( scanner.nextInt() );
                }
                case 3 -> {
                    System.out.println("1. Добавить");
                    System.out.println("2. Удалить");
                    switch (scanner.nextInt()){
                        case 1->{
                            postavchikMenu.drawListPostavchik();
                            System.out.print("Выберите нового поставщика: ");
                            tovarSklad.setId_postav( scanner.nextLong() );
                        }
                        case 2->{
                            Postavchik postavchik = postavchikService.find(tovarSklad.getId_postav());
                            System.out.println(postavchik.getName());

                            System.out.println("Вы хотите его удалить?");
                            System.out.println("1.Да");
                            System.out.println("2.Нет");
                            switch (scanner.nextInt()){
                                case 1->{
                                    tovarSklad.setId_postav(0L);
                                    skladService.update(tovarSklad);
                                }
                                case 2->{
                                    changeTovar();
                                }
                            }
                        }
                    }

                }
                case 9 -> {
                    drawTovar();
                }
                case 0 -> {
                    skladService.update(tovarSklad);
                    tovarService.update(tovar);
                    drawTovar();
                }
            }
        }else {
            changeTovarSklad2(id_tovar);
        }
    }
    private void changeTovarSklad2(Long id) throws SQLException {
        System.out.println("Нет такого товара в отделах!!!");
        Tovar tovarSklad = skladService.find(id);
        System.out.println("--- Изменение товара на складе ---");
        System.out.println("Что хотите изменить?");
        System.out.println("1. Название");
        System.out.println("2. Количество на складе");
        System.out.println("3. Поставщик");
        System.out.println("9. Назад ");
        System.out.println("0. Сохранить и выйти ");

        switch (scanner.nextInt()) {
            case 1 -> {
                System.out.print("Введите новое название: ");
                String name = scanner.next();
                tovarSklad.setNaztov(name);
                skladService.update(tovarSklad);
            }
            case 2 -> {
                System.out.println("Количество товара на складе: "+tovarSklad.getKolvo());
                System.out.println("Введите новое количество: ");
                tovarSklad.setKolvo( scanner.nextInt() );
                skladService.update(tovarSklad);
            }
            case 3 -> {
                postavchikMenu.drawListPostavchik();
                System.out.print("Выберите нового поставщика: ");
                tovarSklad.setId_postav( scanner.nextLong() );
                skladService.update(tovarSklad);
            }
            case 9 -> {
                drawTovar();
            }
            case 0 -> {
                skladService.update(tovarSklad);
                drawTovar();
            }
        }
    }
    private void drawListTovar() throws SQLException {
        System.out.println();
        System.out.println("--- Список товара ---");
        tovarService.getAll().forEach(System.out::println);
    }

}