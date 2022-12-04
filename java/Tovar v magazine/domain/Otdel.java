package test.domain;

public class Otdel {
    private Long id;
    private String name;
    int  nch;
    int nmin;
    int kch;
    int kmin;


    public Otdel(Long id, String name, int nch, int nmin, int kch, int kmin){
        this.id=id;
        this.name=name;
        this.nch=nch;
        this.nmin=nmin;
        this.kch=kch;
        this.kmin= kmin;
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

    public void setNch(int nch) {
        this.nch = nch;
    }

    public int getNch() {
        return nch;
    }

    public void setNmin(int nmin) {
        this.nmin = nmin;
    }

    public int getNmin() {
        return nmin;
    }

    public void setKch(int kch) {
        this.kch = kch;
    }

    public int getKch() {
        return kch;
    }

    public void setKmin(int kmin) {
        this.kmin = kmin;
    }

    public int getKmin() {
        return kmin;
    }

    @Override
    public String toString() {
        return id+ " "+ name +" "+ nch+":"+ nmin+ "-"+ kch+":"+ kmin;
    }
}
