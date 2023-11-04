package Treatment;

public abstract class Template {
    public void print (){
        System.out.println("\n ----------------------------\n");
        System.out.println("Начало обработки заказа");
        show();
        System.out.println("Конец обработки заказа");
    }

    public abstract void show();
}
