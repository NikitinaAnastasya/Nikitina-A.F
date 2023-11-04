package test.view;

import test.Service.Service;
import test.domain.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    private final Service<Tovar> tovarService;
    private final Service<Otdel> otdelService;
    private final Service<Tovar> skladService;
    private final Service<Postavchik> postavchikService;
    private final Service<Prodavec> prodavecService;
    private final Service<Pokupatel> pokupatelService;
    private TovarMenu tovarMenu;
    private OtdelMenu otdelMenu;
    private PokupatelMenu pokupatelMenu;
    private PostavchikMenu postavchikMenu;
    private ProdavecMenu prodavecMenu;
    public Menu(Service<Tovar> tovarService, Service<Otdel> otdelService, Service<Tovar> skladService,
                Service<Postavchik> postavchikService, Service<Prodavec> prodavecService,
                Service<Pokupatel> pokupatelService) {
        this.tovarService = tovarService;
        this.otdelService = otdelService;
        this.skladService = skladService;
        this.postavchikService = postavchikService;
        this.prodavecService = prodavecService;
        this.pokupatelService = pokupatelService;
        this.otdelMenu=new OtdelMenu(this);
        this.pokupatelMenu= new PokupatelMenu(this);
        this.postavchikMenu=new PostavchikMenu(this);
        this.tovarMenu=new TovarMenu(this,otdelMenu,postavchikMenu,skladService,tovarService);
        this.prodavecMenu= new ProdavecMenu(this,otdelMenu);
    }

    public void draw() throws SQLException {
        System.out.println("--- MENU ---");
        System.out.println("1. Товар");
        System.out.println("2. Отдел");
        System.out.println("3. Продавцы");
        System.out.println("4. Поставщик");
        System.out.println("5. Покупатель");
        System.out.println("6.Список отделов ");
        System.out.println("7. Список товаров с поставщиками");
        System.out.println("8. Список товаров в отделах");
        System.out.println("9. Список поставщиков");
        System.out.println("10. Список продавцов");
        System.out.println("11. Список покупателей");
        System.out.println("12. Общий список для товара в отделах с продавцами ");


        execute();
    }

    private void execute() throws SQLException {
        int command = scanner.nextInt();

        switch (command){
            case 1-> {
                tovarMenu.drawTovar();
            }
            case 2->{
                otdelMenu.drawOtdel();
            }
            case 3->{
                prodavecMenu.drawProdavec();
            }
            case  4->{
                postavchikMenu.drawPostavchik();
            }
            case 5->{
                pokupatelMenu.drawPokupatel();
            }
            case 6->{
                otdelMenu.drawListOtdel();
            }
            case 7->{
                drawPoPostav();
            }
            case 8->{
                drawPoTowar();
            }
            case 9 -> {
                postavchikMenu.drawListPostavchik();
            }
            case 10-> {
                prodavecMenu.drawListProdavec();
            }
            case 11->{
                pokupatelMenu.drawListPokupatel();
            }
            case  12 ->{
                drawPoOtdel();
            }
        }
    }
    private void drawPoOtdel() throws SQLException {
        List<Otdel> all = otdelService.getAll();
        for (Otdel o : all) {
            System.out.println(o.getName());
            List<Prodavec> listPod = prodavecService.getListPoId(o.getId());
            for (Prodavec p:listPod) {
                System.out.println(p.getName());
            }
            tovarService.getListPoId(o.getId()).forEach(System.out::println);
        }

    }
    private  void  drawPoTowar() throws SQLException {
        List<Otdel> all = otdelService.getAll();
        for (Otdel l :
                all) {
            System.out.println(l.getName());
            tovarService.getListPoId(l.getId()).forEach(System.out::println);
        }
    }
    private void drawPoPostav() throws SQLException {
        List<Postavchik> all = postavchikService.getAll();
        for (Postavchik p : all) {
            System.out.println("--- Поставщик ----");
            System.out.println(p.getName());
            List<Tovar> listPoIdPostav = skladService.getListPoIdPostav(p.getId());
            System.out.println("--- Товар ---");
            for (Tovar t : listPoIdPostav) {
                System.out.println(t.getNaztov());
            }
        }
    }
}
