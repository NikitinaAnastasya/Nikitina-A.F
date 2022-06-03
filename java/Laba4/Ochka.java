package Spusok;

class Ochka extends DataBaseZO {
	
	private int zachetka;
	private String lastName;
    private String firstName;
    private String group;
    private String kafedra;
    private String dusciplina;
    private int ocenka;
    private String prepod;
    private int bal;
    private int srbal;

    Ochka( int zachetka, String lastName, String firstName, String group,
    		String kafedra, String dusciplina, int ocenka, String prepod, int bal, int srbal) {
        this.zachetka = zachetka;
    	this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
        this.kafedra = kafedra;
        this.dusciplina = dusciplina;
        this.ocenka = ocenka;
        this.prepod = prepod;
        this.bal = bal;
        this.srbal = srbal;
        
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
        return "Ochka. " + " Nomer zachetku: " + zachetka +", Famuliy: " + lastName + ", Name: " + firstName +  
                " Group: " + group + " Kafedra: " + kafedra +" Duscipluna: " + dusciplina + " Ocenka: " + 
        		" Famuliy prepodavateli: " + prepod + ". Bal ege: " + bal + " Sr bal attestata: " + srbal + "\n";
    }
 
}
