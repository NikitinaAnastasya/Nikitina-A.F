package test.view;

import test.Service.Service;
import test.Service.ServicePostavchik;
import test.Service.ServiceSklad;
import test.domain.Postavchik;
import test.domain.Tovar;
import test.repository.PostavchikRepository;
import test.repository.SkladRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class PostavchikMenu {
    Scanner scanner = new Scanner(System.in);

    private  Menu menu ;


    private  final Service<Postavchik> postavchikService = new ServicePostavchik(
            new PostavchikRepository());
    private final Service<Tovar> skladService = new ServiceSklad(new SkladRepository());

    public PostavchikMenu(Menu menu) {
        this.menu=menu;
    }

    public void drawPostavchik() throws SQLException {
        System.out.println("---Поставщики----");
        System.out.println("1.Добавить");
        System.out.println("2.Удалить");
        System.out.println("3.Редактировать");
        System.out.println("0. Назад");
        int s=scanner.nextInt();
        switch (s) {
            case 1 -> newPostavchik();
            case 2 -> {
                System.out.println("not");
                deletePostavchik();
            }
            case 3->{
                System.out.println("!!!!");
                change();
            }
            case 0 -> menu.draw();
        }
    }
    private void  newPostavchik() throws SQLException {
        System.out.println("Введите данные поставщика");
        System.out.print("Название: ");
        String name = scanner.next();
        System.out.print(" номер телефона");
        Long telefon = scanner.nextLong();
        Postavchik postavchik = new Postavchik(null, name, telefon);
        postavchikService.save(postavchik);
    }
    void  drawListPostavchik() throws SQLException {
        System.out.println();
        System.out.println("---Список поставщиков---");
        postavchikService.getAll().forEach(System.out::println);
    }
    private void deletePostavchik() throws SQLException {
        drawListPostavchik();
        System.out.println("Выберите поставщика, для удаления");
        Long id= scanner.nextLong();
        Postavchik postavchik= postavchikService.find(id);
        postavchikService.delete(postavchik);
    }
    private void change() throws SQLException {
        drawListPostavchik();
        System.out.println("Выберите поставщика для изменения");
        Long id = scanner.nextLong();

        Postavchik postavchik = postavchikService.find(id);

        System.out.println("Выберите что изменить");
        System.out.println("1.Название");
        System.out.println("2.Номер телефона");
        System.out.println("3.Удаление товара");
        System.out.println("9.Созранить и выйти");
        System.out.println("0.Назад");

        switch (scanner.nextInt()) {
            case 1 -> {
                System.out.println("Введите новое название");
                postavchik.setName(scanner.next());

            }
            case 2 -> {
                System.out.println("Введите новый номер телефона");
                postavchik.setTelefon(scanner.nextLong());
            }
            case 3 -> {
                skladService.getListPoIdPostav(postavchik.getId()).forEach(System.out::println);
                System.out.println("Выберите какой товар хотите удалить у это поставщика: ");
                Long id_tovar = scanner.nextLong();
                Tovar tovar = skladService.find(id_tovar);
                tovar.setId_postav(0L);
                skladService.update(tovar);
                System.out.println("Успешно!!!");
            }
            case 9->{
                postavchikService.update(postavchik);
                drawPostavchik();
            }
            case 0->{
                drawPostavchik();
            }
        }
    }
}
