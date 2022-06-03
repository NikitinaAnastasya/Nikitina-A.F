package Spusok;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class DataBaseZO extends Main {
	
	private List<Zaochka> zo = new ArrayList<>();
	private List<Ochka> oc = new ArrayList<>();
	private List<Cel> ce = new ArrayList<>();
	
    void addZaochka(Zaochka Zaochka) {

    	zo.add(Zaochka);

    }
    
    void addOchka(Ochka ochka) {

    	oc.add(ochka);

    }
    
    void addCel(Cel cel) {
    	
    	ce.add(cel);
    	
    }

    Zaochka newZaochka() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vvedute ¹ zachetku: ");
        int zachetka = scan.nextInt();
        System.out.print("Vvedute famuluy: ");
        String lastName = scan.next();
        System.out.print("Vvedute name: ");
        String firstName = scan.next();
        System.out.print("Vvedute group: ");
        String group = scan.next();
        System.out.print("Vvedute kafedra: ");
        String kafedra = scan.next();
        System.out.print("Vvedute duscipluna: ");
        String dusciplina = scan.next();
        System.out.print("Vvedute ocenka: ");
        int ocenka = scan.nextInt();
        System.out.print("Vvedute famului prepodavateli: ");
        String prepod = scan.next();
        System.out.println("Vvedute mesto work: ");
        String work = scan.next();
        System.out.println("Vvedute dolshnost: ");
        String post = scan.next();
        System.out.println("Vvedute summa obyshenui: ");
        int sum = scan.nextInt();
        Zaochka h = new Zaochka(  zachetka,  lastName,  firstName,  group,
        		 kafedra,  dusciplina,  ocenka,  prepod,  work,
        		 post,  sum);
        System.out.println(h);
        return h;
    	}
    
    Ochka newOC() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vvedute ¹ zachetku: ");
        int zachetka = scan.nextInt();
        System.out.print("Vvedute famuluy: ");
        String lastName = scan.next();
        System.out.print("Vvedute name: ");
        String firstName = scan.next();
        System.out.print("Vvedute group: ");
        String group = scan.next();
        System.out.print("Vvedute kafedra: ");
        String kafedra = scan.next();
        System.out.print("Vvedute duscipluna: ");
        String dusciplina = scan.next();
        System.out.print("Vvedute ocenka: ");
        int ocenka = scan.nextInt();
        System.out.print("Vvedute famului prepodavateli: ");
        String prepod = scan.next();
        System.out.println("Vvedute bal EGE: ");
        int  bal = scan.nextInt();
        System.out.println("Vvedute sr bal atestata: ");
        int srbal = scan.nextInt();
        Ochka h = new Ochka( zachetka,  lastName,  firstName,  group,
        		 kafedra,  dusciplina,  ocenka,  prepod, bal, srbal);
        System.out.println(h);
        return h;
    }
 
    Cel newCE() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vvedute ¹ zachetku: ");
        int zachetka = scan.nextInt();
        System.out.print("Vvedute famuluy: ");
        String lastName = scan.next();
        System.out.print("Vvedute name: ");
        String firstName = scan.next();
        System.out.print("Vvedute group: ");
        String group = scan.next();
        System.out.print("Vvedute kafedra: ");
        String kafedra = scan.next();
        System.out.print("Vvedute duscipluna: ");
        String dusciplina = scan.next();
        System.out.print("Vvedute ocenka: ");
        int ocenka = scan.nextInt();
        System.out.print("Vvedute famului prepodavateli: ");
        String prepod = scan.next();
        System.out.println("Vvedute name celevogo predpruitui: ");
        String  pred = scan.next();
        System.out.println("Vvedute summa obyshenui: ");
        int sum = scan.nextInt();
        Cel h = new Cel( zachetka,  lastName,  firstName,  group,
        		 kafedra,  dusciplina,  ocenka,  prepod, pred, sum);
        System.out.println(h);
        return h;
    }
    
    void showZO() {
        zo.forEach(System.out::println);
    }
    
    void showOC() {
    	oc.forEach(System.out::println);
    }
    
    void showCE() {
    	ce.forEach(System.out::println);
    }

}
