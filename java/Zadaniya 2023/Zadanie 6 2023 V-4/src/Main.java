import Treatment.Confirmation;
import Treatment.Delivery;
import Treatment.Package;
import Treatment.Template;

public class Main {
    public static void main(String[] args) {
        Template conf = new Confirmation();
        Template pack = new Package();
        Template del = new Delivery();

        conf.print();
        pack.print();
        del.print();

    }
}