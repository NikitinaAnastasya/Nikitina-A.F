public class Otdel {
    String nazvan;
    int cr1;
    String cr11;
    int cr2;
    String cr22;

    Otdel(String nazvan, int cr1, String cr11, int cr2, String cr22) {
        this.nazvan = nazvan;
        this.cr1 = cr1;
        this.cr11 = cr11;
        this.cr2 = cr2;
        this.cr22 = cr22;
    }

    public void setNazvan(String nazvan) {
        this.nazvan = nazvan;
    }

    public String getNazvan() {
        return nazvan;
    }

    public void setCr1(int cr1) {
        this.cr1 = cr1;
    }

    public int getCr1() {
        return cr1;
    }

    public void setCr11(String cr11) {
        this.cr11 = cr11;
    }

    public String getCr11() {
        return cr11;
    }

    public void setCr2(int cr2) {
        this.cr2 = cr2;
    }

    public int getCr2() {
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
