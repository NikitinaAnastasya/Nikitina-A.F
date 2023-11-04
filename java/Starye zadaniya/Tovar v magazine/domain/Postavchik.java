package test.domain;

public class Postavchik {
    private Long id;
    private String name;
    private Long telefon;


    public Postavchik(Long id, String name, Long telefon){
        this.id= id;
        this.name= name;
        this.telefon= telefon;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTelefon(Long telefon) {
        this.telefon = telefon;
    }

    public Long getTelefon() {
        return telefon;
    }

    @Override
    public String toString() {
        return id+" "+ name+ " "+ telefon;
    }
}
