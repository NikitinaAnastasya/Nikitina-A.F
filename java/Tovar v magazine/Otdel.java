package test;

import java.util.*;

public class Otdel {
    String nazvan;
    String cr1;
    String cr11;
    String cr2;
    String cr22;
    List<Tovar> tovar = new ArrayList<>();
    List<String> prod = new ArrayList<>();
    Otdel(String nazvan, String cr1, String cr11, String cr2, String cr22, List<Tovar> tovar,List<String> prod) {
        this.nazvan = nazvan;
        this.cr1 = cr1;
        this.cr11 = cr11;
        this.cr2 = cr2;
        this.cr22 = cr22;
        this.tovar.addAll(new ArrayList<>());
        this.prod.addAll(new ArrayList<>());
    }


    public String splitTovar(){

        List<String> arr=new ArrayList<>();
        for(int i=0;i<tovar.size();i++){
            arr.add( tovar.get(i).getNaztov() +" "+ tovar.get(i).getCena() +" "+ tovar.get(i).getKolvo() );
        }

        String g=String.join(",",arr);
        return g;
    }
    public String splitProd(){
        String g = String.join(",",prod);
        return g;
    }

    public String poiskPoIdNameTov(int a){
        String name= tovar.get(a).getNaztov();
        return name;
    }
    public int poiskKolvoPoIdTov(int a){
        int x=tovar.get(a).getKolvo();
        return x;
    }
    public void deleteProd(int a){
        prod.remove(a);
        System.out.println("Удалено");
    }
    public void setProd(String prod) {
        this.prod.add(prod) ;
        System.out.println("Добавлен");
    }

    public void getProd() {
        for(int i=0;i< prod.size();i++){
            System.out.println(i+" "+prod.get(i));
        }
    }

    public void deleteTovar(int a){
        tovar.remove(a);
        System.out.println("Удалено");
    }

    public void setTovar(Tovar tovar) {
        this.tovar.add(tovar);
    }

    public List<Tovar> getTovar() {
        for(int i=0;i<tovar.size();i++){
            System.out.println(tovar.get(i));
        };
        return null;
    }
    public void getIdTovar(){
        for(int i=0;i<tovar.size();i++){
            System.out.println(i+" "+tovar.get(i));
        };
    }

    public void setNazvan(String nazvan) {
        this.nazvan = nazvan;
    }

    public String getNazvan() {
        return nazvan;
    }

    public void setCr1(String cr1) {
        this.cr1 = cr1;
    }

    public String getCr1() {
        return cr1;
    }

    public void setCr11(String cr11) {
        this.cr11 = cr11;
    }

    public String getCr11() {
        return cr11;
    }

    public void setCr2(String cr2) {
        this.cr2 = cr2;
    }

    public String getCr2() {
        return cr2;
    }

    public void setCr22(String cr22) {
        this.cr22 = cr22;
    }

    public String getCr22() {
        return cr22;
    }

    @Override
    public String toString() {
        return nazvan + " " + cr1 + ":" + cr11 + " - " + cr2 + ":" + cr22;
    }

}
