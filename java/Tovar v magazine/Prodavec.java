public class Prodavec {
    String name;
    int zp;
    String otdel;
    Prodavec(String name, int zp, String otdel){
        this.name= name;
        this.zp= zp;
        this.otdel= otdel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

    public int getZp() {
        return zp;
    }

    public void setOtdel(String otdel) {
        this.otdel = otdel;
    }

    public String getOtdel() {
        return otdel;
    }

    @Override
    public String toString() {
        return name+" "+zp+" "+ otdel;
    }
}
