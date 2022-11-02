package test;

public class Tovar {
    String naztov;
    float cena;
    int kolvo;

    Tovar(String naztov, float cena, int kolvo) {
        this.naztov = naztov;
        this.cena = cena;
        this.kolvo = kolvo ;
    }

    public void setNaztov(String naztov) {
        this.naztov = naztov;
    }

    public String getNaztov() {
        return naztov;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public float getCena() {
        return cena;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }

    public int getKolvo() {
        return kolvo;
    }

        @Override
        public String toString() {
            return naztov + " " + cena + " " + kolvo;
    }

}
