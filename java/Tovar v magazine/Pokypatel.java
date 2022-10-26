public class Pokypatel {
    int nomerTel;
    int skidka;
    Pokypatel(int nomerTel, int skidka){
        this.nomerTel=nomerTel;
        this.skidka= skidka;
    }

    public void setNomerTel(int nomerTel) {
        this.nomerTel = nomerTel;
    }

    public int getNomerTel() {
        return nomerTel;
    }

    public void setSkidka(int skidka) {
        this.skidka = skidka;
    }

    public int getSkidka() {
        return skidka;
    }

    @Override
    public String toString() {
        return nomerTel+" "+ skidka;
    }
}
