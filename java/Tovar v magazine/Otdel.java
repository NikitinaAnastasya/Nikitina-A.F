import java.util.*;

public class Otdel {
    String nazvan;
    String cr1;
    String cr11;
    String cr2;
    String cr22;
    List<Tovar> tovar = new ArrayList<>();

    Otdel(String nazvan, String cr1, String cr11, String cr2, String cr22, Tovar...tovar) {
        this.nazvan = nazvan;
        this.cr1 = cr1;
        this.cr11 = cr11;
        this.cr2 = cr2;
        this.cr22 = cr22;
        this.tovar.addAll(Arrays.asList((tovar)));
    }

    public void setTovar(Tovar tovar) {
        this.tovar.add(tovar);
    }

    public List<Tovar> getTovar() {
        for(int i=0;i<tovar.size();i++){
            System.out.println(tovar.get(i));
        };
        return null;
    }

    public void setNazvan(String nazvan) {
        this.nazvan = nazvan;
    }

    public String getNazvan() {
        return nazvan;
    }

    public void setCr1(String cr1) {
        this.cr1 = cr1;
    }

    public String getCr1() {
        return cr1;
    }

    public void setCr11(String cr11) {
        this.cr11 = cr11;
    }

    public String getCr11() {
        return cr11;
    }

    public void setCr2(String cr2) {
        this.cr2 = cr2;
    }

    public String getCr2() {
        return cr2;
    }

    public void setCr22(String cr22) {
        this.cr22 = cr22;
    }

    public String getCr22() {
        return cr22;
    }

    @Override
    public String toString() {
        return nazvan + " " + cr1 + ":" + cr11 + " - " + cr2 + ":" + cr22;
    }

}
