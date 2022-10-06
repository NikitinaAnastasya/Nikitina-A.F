public class Tovar {
    String naztov;
    float cena;
    String otdely;

    Tovar(String naztov, float cena, String otdely) {
        this.naztov = naztov;
        this.cena = cena;
        this.otdely = otdely;
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

    public void setOtdely(String otdely) {
        this.otdely = otdely;
    }

    public String getOtdely() {
        return otdely;
    }

    @Override
    public String toString() {
        return naztov + " " + cena + " " + otdely;
    }

}
