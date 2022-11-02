package test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataBase {

    String queryOt="select * from otdels";
    String queryT = "select * from tovars";
    String queryProd = "select * from prodavecs";
    String queryPokyp= "select * from pokypatels";
    String querySk= "select * from sklad";
    String queryPostav= "select * from postavchiks";

    private final String  INSERT_Otdel= "insert into otdels values (?,?,?,?,?,?,?,?)";
    private final String INSERT_Tovar="insert into tovars values (?,?,?,?)";
    private final String INSERT_Prod= "insert into prodavecs values (?,?,?,?)";
    private final String INSERT_Pokyp = "insert into pokypatels valuse(?,?,?)";
    private final String INSERT_Sklad ="insert into sklad values (?,?,?,?)";
    private final String INSERT_Postav ="insert into postavchiks values(?,?,?,?)";

    DBWorker worker = new DBWorker();

    Statement statement;

    Scanner scanner = new Scanner(System.in);
    public List<Otdel> ot = new ArrayList<>();
    private List<Tovar> tov = new ArrayList<>();
    private List<Tovar> sklad= new ArrayList<>();
    private List<Prodavec> prod= new ArrayList<>();
    private List<Pokypatel> pokyp= new ArrayList<>();
    private List<Postavchik> postav= new ArrayList<>();

    //продавец
    void  addProdavec(Prodavec Prodavec){
        prod.add(Prodavec);
    }
    void  deleteProdavec(){
        System.out.println();
        System.out.println("Введите номер продавца: ");
        int w = scanner.nextInt();
        prod.remove(w);
    }
    void changeProdavec(){
        System.out.println();
        System.out.println("Введите номер продавца, которого хотите изменить: ");
        int j = scanner.nextInt();
        System.out.println(prod.get(j));
        System.out.println("Выберете то что хотите изменить : 1. Полностью продавца 2. Фамилию продавца 3.З/п 4. Отдел  ");
        int q = scanner.nextInt();
        if (q == 1) {
            prod.set(j, newProdavec());
        }
        if (q == 2) {
            System.out.println("Введите новую фамилию: ");
            String e = scanner.next();
             prod.get(j).setName(e);
        }
        if (q==3){
            System.out.println("Введите новую з/п  ");
            int g= scanner.nextInt();
            prod.get(j).setZp(g);
        }
        if (q==4){
            showOtdel();
            System.out.println("Введите номер отдела, в которой переводится сотрудник:  ");
            int k= scanner.nextInt();
            prod.get(j).setOtdel( ot.get(k).getNazvan());
        }
    }
    Prodavec newProdavec() {
        System.out.println("Введите фамилию продавца: ");
        String l = scanner.next();
        System.out.println(" Введите з/п: ");
        int h= scanner.nextInt();
        showOtdel();
        System.out.println("Введите номер отдела: ");
        int u= scanner.nextInt();
        String p= ot.get(u).getNazvan();
        Prodavec b= new Prodavec(l,h,p);
        ot.get(u).setProd(l);
        return b;
    }
    void showProdavec(){
        for(int i=0; i<prod.size(); i++){
            System.out.println(i+ " "+ prod.get(i));
        }
    }

    //покупатель
    void  addPokypatel(Pokypatel Pokypatel){
        pokyp.add(Pokypatel);
    }
    void changePokypatel(){
        System.out.println();

        System.out.println("Введите номер покупателя, которого хотите изменить: ");
        int j = scanner.nextInt();
        System.out.println(pokyp.get(j));
        System.out.println("Выберете то что хотите изменить : 1. Полностью покупателя 2. Номер телефона 3. Процент скидки  ");
        int q = scanner.nextInt();
        if (q == 1) {
            pokyp.set(j, newPokypatel());
        }
        if (q == 2) {
            System.out.println("Введите новый номер телефона: ");
            int e = scanner.nextInt();
            pokyp.get(j).setNomerTel(e);
        }
        if(q==3){
            System.out.println(" Введите новый процент скидки: ");
            int o=scanner.nextInt();
            pokyp.get(j).setSkidka(o);
        }
    }
    Pokypatel newPokypatel(){
        System.out.println(" Введите номер телефона: ");
        int h= scanner.nextInt();
        System.out.println("Введите процент скидки: ");
        int u= scanner.nextInt();
        Pokypatel b= new Pokypatel(h,u);
        return b;
    }
    void showPokypatel(){
        for(int i=0; i<pokyp.size(); i++){
            System.out.println(i+ " "+ pokyp.get(i));
        }
    }

    //Склад
    void showSklad(){
        for (int i=0;i<sklad.size();i++){
            System.out.println(sklad.get(i));
        }
    }
    void showIdSklad(){
        for (int i=0;i<sklad.size();i++){
            System.out.println(i+" "+sklad.get(i));
        }
    }
    void addNewTovarSkald(Tovar tv){

        float x=tv.getCena()*2;

        Tovar q= new Tovar( tv.getNaztov(), x, tv.getKolvo());
        addTovarNaSklad(q);
    }
    void changeCenaTovaraNaSklad(String nameTovar, float newCena){
        int id=poiskIDPoName(nameTovar);
        sklad.get(id).setCena(newCena*2);
    }
    void addTovarNaSklad( Tovar tovar){
        sklad.add(tovar);
    }
    int poiskIDPoName(String nameTovar){
        int id=0;
        for(int i=0;i<sklad.size();i++){
            if ( nameTovar.equals( sklad.get(i).getNaztov() ) ){
                id=i;
            }
        }
        return id;
    }
    void changeKolvoTovaraNaSklad(String nameTovar,int newKolvo, String s){
        int id=poiskIDPoName(nameTovar);
        if (s.equals("+")){

            sklad.get(id).setKolvo( sklad.get(id).getKolvo()+newKolvo );

        }
        if (s.equals("-")){
            sklad.get(id).setKolvo( sklad.get(id).getKolvo()-newKolvo );
        }
    }



    //Поставщик
    void addPostavchik(Postavchik Postavchik){
        postav.add(Postavchik);
    }
    void deletePostavchik(){
        System.out.println();
        System.out.println("Введите номер поставщика: ");
        int w = scanner.nextInt();
        prod.remove(w);
    }
    void changePostavchik() {
        System.out.println();
        System.out.println("Введите номер поставщика, которого хотите изменить: ");
        int j = scanner.nextInt();
        System.out.println(postav.get(j));
        System.out.println("Выберете то что хотите изменить : 1. Полностью поставщика" +
                " 2.Название поставцика  3. Номер телефона 4.Список товаров     ");
        int q = scanner.nextInt();
        if (q == 1) {
            postav.set(j, newPostavchik());
        }
        if (q == 2) {
            System.out.println("Введите новое название: ");
            String e = scanner.next();
            postav.get(j).setNazvanieKom(e);
        }
        if (q == 3) {
            System.out.println("Введите новый номер телефона:  ");
            int g = scanner.nextInt();
            postav.get(j).setTelefon(g);
        }
        if(q==4){
            System.out.println("1. изменение списка товаров 2. изменение количества товаров");
        int a = scanner.nextInt();
        if (a==1){
            System.out.println("1. удалить 2. добавить");
            int w=scanner.nextInt();
            if (w==1) {
                postav.get(j).getIdTovar();
                System.out.println("Введите номер товара: ");
                int y=scanner.nextInt();

                changeKolvoTovaraNaSklad( postav.get(j).poiskNazvanPoId(y), postav.get(j).poiskKolvoPoId(y), "-" );
                postav.get(j).deleteTovar(y);

            }
            if (w==2){
                System.out.println("1. Товар 2. Новый товар");
                int t=scanner.nextInt();
                if (t==1){
                    showTovar();
                    System.out.println("Введите номер товара: ");
                    int r=scanner.nextInt();

                    postav.get(j).setTovar( addKolvoTovarYPostav(r) );

                }
                if (t==2){
                    addTovar(newTovarPostav());
                    Tovar s=tov.get(tov.size()-1);
                    postav.get(j).setTovar( s );
                    addNewTovarSkald(s);
                }
            }
        }
        if (a==2){
            postav.get(j).getIdTovar();
            System.out.println("Выберите товар у которого хотите  изменить количество: ");
            boolean f=true;
            while (f){
                f=false;
                int x= scanner.nextInt();
                if (x>=0){
                    System.out.println("Введите новое количество товара:");
                    int r=scanner.nextInt();
                    postav.get(j).changeKolvoTovar(x,r);

                    System.out.println("Выполнено. Если хотите закончить наберите -1");
                }
                else {
                    f=false;
                    break;
                }
            }
        }
        }
    }

    void prihod(){
        showIdPostav();
        System.out.println("Выберите постовщика: ");
        int x=scanner.nextInt();

        showTovar();
        System.out.println("Выберите товар который надо добавить: ");

        int n=0;
        while(n==0){
            int s=scanner.nextInt();
            if (s>=0){
                postav.get(x).setTovar( addKolvoTovarYPostav(x) );
                System.out.println("Успешно. -1 выход");
            }
            else {
                n=1;

            }
        }

    }
    Postavchik newPostavchik(){


        System.out.println("Введите  название компании: ");
        String name =scanner.next();

        System.out.println("Введите номер телефона: ");
        int tel=scanner.nextInt();



        Postavchik o= new Postavchik(name,tel,null);
        return o;
    }

    Tovar addKolvoTovarYPostav(int a){
        System.out.println("Введите цену товара: ");
        float w = scanner.nextFloat();

        System.out.println("Введите количество привезенного товара: ");
        int r=scanner.nextInt();

        Tovar o = new Tovar( tov.get(a).getNaztov(), w,r);

        changeCenaTovaraNaSklad(tov.get(a).getNaztov(),w);

        changeKolvoTovaraNaSklad(tov.get(a).getNaztov(),r,"+");
        return o;
    }

    Tovar newTovarPostav(){
        String name=null;
        int n=0;


        while (n==0){
            System.out.println("Введите название товара: ");
            name=scanner.next();
            if (n==0) {
                for (int i = 0; i < tov.size(); i++) {
                    if (tov.get(i).getNaztov().equals(name)) {
                        System.out.println("Такой товар уже имеется в списках!!!");
                    }
                }
            }
            else {
                System.out.println("Названия товара нет в списках!!!");
                n=1;
                break;
            }
        }


        System.out.println("Введите цену товара у поставщика: ");
        float cena=scanner.nextFloat();

        System.out.println("Введите кол-во товара: ");
        int kolvo = scanner.nextInt();

        Tovar o = new Tovar(name,cena,kolvo);

        return o;
    }



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
        System.out.println("Выберете то что хотите изменить : 1. Полностью отдел 2. Название отдела " +
                "3.Время работы 4.Сотрудники 5.Товары в отделе");
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
        if (q==4){
            System.out.println("1. Добавить 2.Удалить ");
            int y=scanner.nextInt();
            if (y==2){
                ot.get(j).getProd();
                System.out.println("Выберите сотрудника:");
                int a=scanner.nextInt();
                ot.get(j).deleteProd(a);
            }
            if(y==1){
                showProdavec();
                System.out.println("Выберите сотрудника: ");
                int x=scanner.nextInt();
                ot.get(j).setProd( prod.get(x).getName() );
            }
        }
        if (q==5){
            System.out.println("1 Добавить 2 Удалить");
            int x=scanner.nextInt();
            if (x==1){
                showIdSklad();
                System.out.println("Введите номер товара: ");
                int w=scanner.nextInt();

                ot.get(j).setTovar( changeTovaraDlyOtdela( sklad.get(w), w ) );
            }
            if (x==2){
                ot.get(j).getIdTovar();
                System.out.println("Введите номер товара:");
                int g=scanner.nextInt();
                changeKolvoTovaraNaSklad( ot.get(j).poiskPoIdNameTov(g), ot.get(j).poiskKolvoPoIdTov(g),"+" );
                ot.get(j).deleteTovar( g );
            }
        }

    }

    Tovar changeTovaraDlyOtdela(Tovar tv,int a){
        System.out.println("Количество товара на складе = " + tv.getKolvo());
        int n=0;
        int kolvo=0;
        while (n==0){
            System.out.println("Введите количество товара нужный в отделе: ");
            int x=scanner.nextInt();
            if (x<=tv.getKolvo()){
                kolvo =x;
                changeKolvoTovaraNaSklad(tv.getNaztov(),x,"-");
                break;
            }
            else {
                System.out.println("Товара не хватает на складе!!!");
            }
        }

        Tovar b= new Tovar(tv.getNaztov(), tv.getCena(), kolvo);
        return b;
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
        Otdel o = new Otdel(l, cr1, cr11, cr2, cr22,null,null);
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
        System.out.println("Выберете то, что хотите изменить: 1. Полностью товар 2.Название товара 3. Цену товара ");
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
    }

    void showTovar() {
        for (int i = 0; i < tov.size(); i++) {
            System.out.println(i + " " + tov.get(i).getNaztov());
        }
    }
    void showTovarVOtdel(){

    }

    Tovar newTovar() {

        System.out.println("Введите название товара: ");
        String l = scanner.next();

        Tovar o = new Tovar(l, 0, 0);
        addNewTovarSkald(o);
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
        if (cr1.equals("null")){
        }
        else {
            ((Otdel)ot.get(n)).setCr1(cr1);
        }
        if (cr11.equals("null")){
        }
        else {
            ((Otdel)ot.get(n)).setCr11(cr11);
        }
        if (cr2.equals("null")){
        }
        else{
            ((Otdel)ot.get(n)).setCr2(cr2);
        }
        if (cr22.equals("null")){
        }
        else{
            ((Otdel)ot.get(n)).setCr22(cr22);
        }

    }

    void showProdVOtdel(){
        for(int i=0;i< ot.size();i++){
            System.out.println( ot.get(i).getNazvan() );
            ot.get(i).getProd();
        }
    }
    void showTovarProdVOtdel(){
        for (int i=0;i< ot.size();i++){
            System.out.println( ot.get(i).getNazvan() );
            System.out.println("Продавцы:");
            ot.get(i).getProd();
            System.out.println("Товары в этом отделе: ");
            ot.get(i).getTovar();
        }
    }
    void showPostav(){
        for(int i=0;i<postav.size();i++){
            System.out.println(postav.get(i));
        }
    }
    void showIdPostav(){
        for(int i=0;i<postav.size();i++){
            System.out.println(i+" "+postav.get(i));
        }
    }

    //работа с бд
void save(){
    try{
        statement = worker.getConnect().createStatement();
        statement.executeUpdate("delete from otdels");
        statement.executeUpdate("delete from tovars");
        statement.executeUpdate("delete from prodavecs");
        statement.executeUpdate("delete from pokypatels");
        statement.executeUpdate("delete from sklad");
        statement.executeUpdate("delete from postavchiks");

        PreparedStatement preStatOt = worker.getConnect().prepareStatement(INSERT_Otdel);
        for(int i=0; i< ot.size();i++){
            String rezultTovar = null;
            String rezultProd = null;

                rezultTovar = ot.get(i).splitTovar();

                rezultProd = ot.get(i).splitProd();

            preStatOt.setInt(1,i+1);
            preStatOt.setString(2,ot.get(i).getNazvan());
            preStatOt.setString(3,ot.get(i).getCr1());
            preStatOt.setString(4,ot.get(i).getCr11());
            preStatOt.setString(5,ot.get(i).getCr2());
            preStatOt.setString(6,ot.get(i).getCr22());
            preStatOt.setString(7,rezultTovar);
            preStatOt.setString(8,rezultProd);

            preStatOt.execute();
        }
        PreparedStatement preStatTovar = worker.getConnect().prepareStatement(INSERT_Tovar);
        for(int i=0;i<tov.size();i++){

            preStatTovar.setInt(1,i+1);
            preStatTovar.setString(2,tov.get(i).getNaztov());
            preStatTovar.setFloat(3, tov.get(i).getCena());
            preStatTovar.setInt(4, tov.get(i).getKolvo());

            preStatTovar.execute();
        }
        PreparedStatement preStatProd = worker.getConnect().prepareStatement(INSERT_Prod);
        for(int i=0;i< prod.size();i++){

            preStatProd.setInt(1,i+1);
            preStatProd.setString(2, prod.get(i).getName());
            preStatProd.setInt(3, prod.get(i).getZp());
            preStatProd.setString(4, prod.get(i).getOtdel());

            preStatProd.execute();
        }
        PreparedStatement preStatPokyp = worker.getConnect().prepareStatement(INSERT_Pokyp);
        for (int i=0;i<pokyp.size();i++){

            preStatPokyp.setInt(1,i+1);
            preStatPokyp.setInt(2, pokyp.get(i).getNomerTel());
            preStatPokyp.setInt(3, pokyp.get(i).getSkidka());

            preStatPokyp.execute();
        }
        PreparedStatement preStatPostav = worker.getConnect().prepareStatement(INSERT_Postav);
        for (int i=0;i<postav.size();i++){

            String rezultTovar= postav.get(i).splitTovar();

            preStatPostav.setInt(1,i+1);
            preStatPostav.setString(2, postav.get(i).getNazvanieKom());
            preStatPostav.setInt(3, postav.get(i).getTelefon());
            preStatPostav.setString(4, rezultTovar);

            preStatPostav.execute();
        }
        PreparedStatement preStatSklad = worker.getConnect().prepareStatement(INSERT_Sklad);
        for (int i=0;i<sklad.size();i++){

            preStatSklad.setInt(1,i+1);
            preStatSklad.setString(2, sklad.get(i).getNaztov());
            preStatSklad.setFloat(3, sklad.get(i).getCena());
            preStatSklad.setInt(4,sklad.get(i).getKolvo());

            preStatSklad.execute();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
void loading(){
        try{
            statement = worker.getConnect().createStatement();
            ResultSet resultSetOt = statement.executeQuery(queryOt);
            int a=0;
            while (resultSetOt.next()){

                String name =resultSetOt.getString("name");
                String nch= resultSetOt.getString("nch");
                String nmin= resultSetOt.getString("nmin");
                String kch= resultSetOt.getString("kch");
                String kmin=resultSetOt.getString("kmin");
                String tovarLists=resultSetOt.getString("tovarlists");
                String prodLists=resultSetOt.getString("prodlists");

                String[] spTovar= tovarLists.split(",");
                String[] spProd= prodLists.split(",");

                Otdel o = new Otdel(name,nch,nmin,kch,kmin,null,null);
                ot.add(o);

                for (int i=0;i< spProd.length;i++){
                    ot.get(a).setProd(spProd[i]);
                }
                for(int i=0;i<spTovar.length;i++){
                    String[] sp = spTovar[i].split(" ");
                    String nameT=sp[0];
                    float cena= Float.parseFloat(sp[1]);
                    int kolvo= Integer.parseInt(sp[2]);

                    Tovar s = new Tovar(nameT,cena,kolvo);
                    ot.get(a).setTovar(s);
                }

                a+=1;
            }
            ResultSet resultSetTovar =statement.executeQuery(queryT);
            while(resultSetTovar.next()){

                String name = resultSetTovar.getString("name");
                float cena = resultSetTovar.getFloat("cena");
                int kolvo = resultSetTovar.getInt("kolvo");

                Tovar t= new Tovar(name,cena,kolvo);
                tov.add(t);
            }
            ResultSet resultSetProd = statement.executeQuery(queryProd);
            while (resultSetProd.next()){

                String name = resultSetProd.getString("name");
                int zp = resultSetProd.getInt("zp");
                String otdel = resultSetProd.getString("otdel");

                Prodavec pro = new Prodavec(name,zp,otdel);
                prod.add(pro);
            }
            ResultSet resultSetPokyp = statement.executeQuery(queryPokyp);
            while (resultSetPokyp.next()){

                int tel = resultSetPokyp.getInt("nomertel");
                int skidka = resultSetPokyp.getInt("skidka");

                Pokypatel pok = new Pokypatel(tel,skidka);
                pokyp.add(pok);
            }
            ResultSet resultSetPostav = statement.executeQuery(queryPostav);
            int b=0;
            while (resultSetPostav.next()){

                String name = resultSetPostav.getString("namekomp");
                int tel = resultSetPostav.getInt("telefon");
                String tovarLists = resultSetPostav.getString("tovarlists");

                String[] spTovar= tovarLists.split(",");

                Postavchik pos = new Postavchik(name,tel,null);
                postav.add(pos);

                for(int i=0;i<spTovar.length;i++){
                    String[] sp = spTovar[i].split(" ");
                    String nameT=sp[0];
                    float cena= Float.parseFloat(sp[1]);
                    int skidka= Integer.parseInt(sp[2]);

                    Tovar s = new Tovar(nameT,cena,skidka);
                    postav.get(b).setTovar(s);
                }
                b+=1;
            }
            ResultSet resultSetSklad =statement.executeQuery(querySk);
            while (resultSetSklad.next()){

                String name = resultSetSklad.getString("nametovar");
                float cena = resultSetSklad.getFloat("cena");
                int kolvo = resultSetSklad.getInt("kolvo");

                Tovar s= new Tovar(name,cena,kolvo);
                sklad.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}

}
