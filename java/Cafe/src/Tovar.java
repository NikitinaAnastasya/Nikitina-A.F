public class Tovar {
    private int id;
    private String name;
    private double cena;
    private String wid;

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }

    private int kolvo;

    public Tovar(int id, String name, double cena, String wid, int kolvo) {
        this.id = id;
        this.name = name;
        this.cena = cena;
        this.wid = wid;
        this.kolvo = kolvo;
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
        this.cena = cena;
    }

    @Override
    public String toString() {
        return id +" "+ name+ " - "+ cena;
    }
}
