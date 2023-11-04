package test.view;

import test.Service.Service;
import test.Service.ServicePokupatel;
import test.domain.Pokupatel;
import test.repository.PokupatelRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class PokupatelMenu {
    Scanner scanner = new Scanner(System.in);

    private final Service<Pokupatel> pokupatelService = new ServicePokupatel(new PokupatelRepository());


    private Menu menu;

    public PokupatelMenu(Menu menu) {
        this.menu=menu;
    }


    public void drawPokupatel() throws SQLException {
        System.out.println("---Покупатели----");
        System.out.println("1.Добавить");
        System.out.println("2.Удалить");
        System.out.println("3.Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()) {
            case 1 -> newPokupatel();
            case 2 -> deletePokupatel();
            case 3 -> changePokupatel();
            case 0 -> menu.draw();
        }
    }
    private void  newPokupatel() throws SQLException {
        System.out.println("Введите данные покупателя: ");
        System.out.print("Телефон: ");
        Long telefon = scanner.nextLong();
        System.out.print("Скидка покупателя: ");
        int skidka = scanner.nextInt();
        Pokupatel pokupatel= new Pokupatel(null, telefon, skidka);
        pokupatelService.save(pokupatel);
    }
    void drawListPokupatel() throws SQLException {
        System.out.println();
        System.out.println("---Список покупателей---");
        pokupatelService.getAll().forEach(System.out::println);

    }
    private  void deletePokupatel() throws SQLException {
        drawListPokupatel();
        System.out.println("Выберите покупателя, которого надо удалить");
        Long id= scanner.nextLong();
        Pokupatel pokupatel= pokupatelService.find(id);
        pokupatelService.delete(pokupatel);
    }
    private  void  changePokupatel() throws SQLException {
        drawListPokupatel();
        System.out.println("Выберите покупателя для изменения");
        Long id = scanner.nextLong();

        Pokupatel pokupatel= pokupatelService.find(id);

        System.out.println("Что изменить?");
        System.out.println("1. Телефон");
        System.out.println("2. Скидку");
        System.out.println("9. Сохранить и выйти");
        System.out.println("0. Назад");


        switch (scanner.nextInt()){
            case 1->{
                System.out.println("Введите новый телефон ");
                pokupatel.setTelefon(scanner.nextLong());
            }
            case 2->{
                System.out.println("Введите новую скидку ");
                pokupatel.setSkidka(scanner.nextInt());
            }
            case 9->{
                pokupatelService.update(pokupatel);
                drawPokupatel();
            }
            case  0 ->{
                drawPokupatel();
            }
        }
    }
}
