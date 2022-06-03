/*
 * Implement the subject area:
 * Accounting for the academic performance of university students. Create a parent class
 * "Student" (record book number, surname, first name, group, department, discipline,
 * assessment, teacher's surname) and child classes:
 * "Full-time department" (EGE grade, average grade of the certificate);
 * "Correspondence department" (place of work, position, amount of training);
 * "Targeted training" (the name of the target company, the amount of training).
 * Implement a class for storing a list of students with a method for adding a new
 * student and a method for printing a list of students.
 */



package Spusok;

import java.util.Scanner;

public class Main {
	
	private static DataBaseZO myDB = new DataBaseZO();
	 
    public static void main(String[] args) {
    	
        menu();
        
    }
 
    private static void menu() {
        Scanner scan = new Scanner(System.in);
        mark:
        while (true) {
            System.out.println("1. Add studenta");
            System.out.println("2. Pokaz vse");
            System.out.println("0. Exit");
            int result = scan.nextInt();
 
            switch (result) {
                case 1:
                	System.out.println("1 Ochka 2 Zaochka 3 Celevoe");
                	int a = scan.nextInt();
                	if (a == 1) {
                		myDB.addOchka(myDB.newOC());
                	}
                    if (a == 2) {
                    	myDB.addZaochka(myDB.newZaochka());	
                    }
                    if (a == 3) {
                    	myDB.addCel(myDB.newCE());
                    }	
                    
                    break;
                case 2:
                	myDB.showOC();myDB.showZO();myDB.showCE();
                    break;
              default:
                    break mark;
            }
        }
    }

}
