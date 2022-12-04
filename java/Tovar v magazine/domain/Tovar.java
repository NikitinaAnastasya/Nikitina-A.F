package test.domain;

public class Tovar {
    private Long id;
    private Long id_otdel;
    private Long id_postav;
    private String naztov;
    private float cena;
    private int kolvo;

    public Tovar(Long id,String naztov, float cena, int kolvo,Long id_otdel,Long id_postav) {
        this.id=id;
        this.naztov = naztov;
        this.cena = cena;
        this.kolvo = kolvo ;
        this.id_otdel=id_otdel;
        this.id_postav=id_postav;
    }

    public void setId_postav(Long id_postav) {
        this.id_postav = id_postav;
    }

    public Long getId_postav() {
        return id_postav;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
            return id+ " "+ naztov + " " + cena + " " + kolvo;
    }

}
