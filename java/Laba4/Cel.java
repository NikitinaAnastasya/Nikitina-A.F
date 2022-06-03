package Spusok;

class Cel extends DataBaseZO {
	
	private int zachetka;
	private String lastName;
    private String firstName;
    private String group;
    private String kafedra;
    private String dusciplina;
    private int ocenka;
    private String prepod;
    private String pred;
    private int sum;

    Cel ( int zachetka, String lastName, String firstName,  String group,
    		String kafedra, String dusciplina, int ocenka, String prepod, String pred, int sum) {
        this.zachetka = zachetka;
    	this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
        this.kafedra = kafedra;
        this.dusciplina = dusciplina;
        this.ocenka = ocenka;
        this.prepod = prepod;
        this.pred = pred;
        this.sum = sum;
        
    }
 
    int getzachetka() {
    	return zachetka;
    }
    
    int getocenka() {
        return ocenka;
    }
 
    String getLastName() {
        return lastName;
    }
 
    @Override
    public String toString() {
        return "Celevoe. " + " Nomer zachetku: " + zachetka +", Famuliy: " + lastName + ", Name: " + firstName +  
                " Group: " + group + " Kafedra: " + kafedra +" Duscipluna: " + dusciplina + " Ocenka: " + 
        		" Famuliy prepodavateli: " + prepod + ". Name celevogo predpruitui: " + pred + " Summa obychenuy: " + sum + "\n";
    }
 
}
