package Spusok;

class Zaochka extends DataBaseZO {
	
	private int zachetka;
	private String lastName;
    private String firstName;
    private String group;
    private String kafedra;
    private String dusciplina;
    private int ocenka;
    private String prepod;
    private String work;
    private String post;
    private int sum;

    Zaochka( int zachetka, String lastName, String firstName, String group,
    		String kafedra, String dusciplina, int ocenka, String prepod, String work,
    		String post, int sum) {
        this.zachetka = zachetka;
    	this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
        this.kafedra = kafedra;
        this.dusciplina = dusciplina;
        this.ocenka = ocenka;
        this.prepod = prepod;
        this.work = work;
        this.post = post;
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
        return "Zaochka. " + " Nomer zachetku: " + zachetka +", Famuliy: " + lastName + ", Name: " + firstName +  
                " Group: " + group + " Kafedra: " + kafedra +" Duscipluna: " + dusciplina + " Ocenka: " + 
        		" Famuliy prepodavateli: " + prepod + "Mesto work: " + work + " Dolshnost: " +
                post + " Vvedute summy obechenui: " + sum + "\n";
    }
 
}
