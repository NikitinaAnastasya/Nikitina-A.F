package test.domain;

public class Prodavec {
    private Long id;
    private  String name;
    private String pol;
    private int zp;
    private  Long id_otdel;


    public Prodavec(Long id, String name, String pol, int zp, Long id_otdel) {
        this.id = id;
        this.name = name;
        this.pol = pol;
        this.zp = zp;
        this.id_otdel = id_otdel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public int getZp() {
        return zp;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    @Override
    public String toString() {
        return name+" "+ pol+" "+ zp+" "+ id_otdel  ;
    }
}
