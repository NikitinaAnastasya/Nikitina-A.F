package test.view;

import test.Service.*;
import test.domain.*;
import test.repository.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Repository<Tovar> tovarRepository = new TovarRepository();
        Service<Tovar> tovarService = new ServiceTovar(tovarRepository);

        Repository<Otdel> otdelRepository=new OtdelRepository();
        Service<Otdel> otdelService = new ServiceOtdel(otdelRepository);

        Repository<Tovar> skladRepository = new SkladRepository();
        Service<Tovar> skladService = new ServiceSklad(skladRepository);

        Repository<Postavchik> postavchikRepository = new PostavchikRepository();
        Service<Postavchik> postavchikService = new ServicePostavchik(postavchikRepository);

        Repository<Prodavec> prodavecRepository = new ProdavecRepository();
        Service<Prodavec> prodavecService= new ServiceProdavec(prodavecRepository);

        Repository<Pokupatel> pokupatelRepository = new PokupatelRepository();
        Service<Pokupatel> pokupatelService= new ServicePokupatel(pokupatelRepository);




        Menu menu = new Menu(tovarService, otdelService, skladService, postavchikService,
                prodavecService, pokupatelService);
        while (true){
            menu.draw();
        }

    }

}

