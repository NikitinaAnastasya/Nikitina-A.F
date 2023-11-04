import java.util.Date;

public class Draving {
    private String draving;
    private Date date;
    public void setDravingAndDate(String draving){
        this.draving = draving;
        this.date= new Date();
    }
    public  Save save(){
        return new Save(draving);
    }
    public void load(Save save){
        draving = save.getDraving();
        date = save.getDate();
    }

    @Override
    public String toString() {
        return "Draving{" +
                "draving='" + draving + '\'' +
                ", date=" + date +
                '}';
    }
}
