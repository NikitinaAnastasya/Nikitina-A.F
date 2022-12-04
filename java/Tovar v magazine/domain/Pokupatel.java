package test.domain;

public class Pokupatel {
    private Long id;
    private Long telefon;
    private  int skidka;

    public Pokupatel(Long id, Long telefon, int skidka) {
        this.id = id;
        this.telefon = telefon;
        this.skidka = skidka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTelefon() {
        return telefon;
    }

    public void setTelefon(Long telefon) {
        this.telefon = telefon;
    }

    public int getSkidka() {
        return skidka;
    }

    public void setSkidka(int skidka) {
        this.skidka = skidka;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", telefon=" + telefon +
                ", skidka=" + skidka;
    }
}
