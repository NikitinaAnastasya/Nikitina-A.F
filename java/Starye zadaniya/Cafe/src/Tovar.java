public class Tovar {
    private int id;
    private String name;
    private double cena;
    private String wid;
    private int kolvo;

    public Tovar(int id, String name, double cena, String wid, int kolvo) {
        this.id = id;
        this.name = name;
        this.cena = cena;
        this.wid = wid;
        this.kolvo = kolvo;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        if (kolvo < 0){
            throw new IllegalArgumentException("Введено отрицательное число");
        }else {
            this.kolvo = kolvo;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCena() {
        return cena;
    }

    public String getWid() {
        return wid;
    }

    public void setCena(double cena) {
        if (cena < 0){
            throw new IllegalArgumentException("Введено отрицательное число");
        }else {
            this.cena = cena;
        }
    }

    @Override
    public String toString() {
        return id +" "+ name+ " - "+ cena;
    }
}
