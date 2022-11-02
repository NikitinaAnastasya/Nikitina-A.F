package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Postavchik {
    DataBase db=new DataBase();
    String nazvanieKom;
    int telefon;
    List <Tovar> tovar= new ArrayList<>();
    Postavchik(String nazvanieKom, int telefon, List<Tovar> tovar ){
        this.nazvanieKom= nazvanieKom;
        this.telefon=telefon;
        this.tovar.addAll(new ArrayList<>());
    }
    public String splitTovar(){

        List<String> arr=new ArrayList<>();
        for(int i=0;i<tovar.size();i++){
            arr.add( tovar.get(i).getNaztov() +" "+ tovar.get(i).getCena() +" "+ tovar.get(i).getKolvo() );
        }

        String g=String.join(",",arr);
        return g;
    }
    public void setNazvanieKom(String nazvanieKom) {
        this.nazvanieKom = nazvanieKom;
    }

    public String getNazvanieKom() {
        return nazvanieKom;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTovar(Tovar tovar) {
        this.tovar.add(tovar);
    }

    public void getTovar() {
        for( int i=0; i< tovar.size(); i++){
            System.out.println(tovar.get(i));;
        }
    }
    public void getIdTovar(){
        for( int i=0; i< tovar.size(); i++){
            System.out.println(i+" " +tovar.get(i));;
        }
    }
    public void changeKolvoTovar(int a,int newKolvo){
        for (int i=0;i<tovar.size();i++){
            if (i==a){
                if (tovar.get(i).getKolvo() > newKolvo){
                    db.changeKolvoTovaraNaSklad( tovar.get(i).getNaztov(),newKolvo,"-" );
                }
                if (tovar.get(i).getKolvo() < newKolvo){
                    db.changeKolvoTovaraNaSklad( tovar.get(i).getNaztov(),newKolvo,"+" );
                }

                tovar.get(i).setKolvo(newKolvo);
            }
        }
    }

    public void deleteTovar(int a){
        for (int i=0; i< tovar.size();i++){
            if (i==a){
                tovar.remove(i);
            }
        }
    }
    public String poiskNazvanPoId(int a){

        String name=tovar.get(a).getNaztov();

        return name;
    }
    public int poiskKolvoPoId(int a){
        int name = tovar.get(a).getKolvo();

        return name;
    }

    @Override
    public String toString() {
        return nazvanieKom+" "+ telefon;
    }
}
