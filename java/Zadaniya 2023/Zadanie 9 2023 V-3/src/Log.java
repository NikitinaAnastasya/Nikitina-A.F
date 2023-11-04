import java.util.ArrayList;
import java.util.List;

public class Log {
    private List<String> list = new ArrayList<>();

    public void getList() {
        System.out.println("вывод журнала\n");
        for (String l : list) {
            System.out.println(l);
        }
    }

    public void setList(String list) {
        this.list.add(list);
    }

}
