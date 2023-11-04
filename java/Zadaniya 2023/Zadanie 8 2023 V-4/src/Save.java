import java.util.Date;

public class Save {
    private final String draving;
    private final Date date;

    public Save(String draving) {
        this.draving = draving;
        this.date = new Date();
    }

    public String getDraving() {
        return draving;
    }

    public Date getDate() {
        return date;
    }
}
