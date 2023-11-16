package Auto;

public class Engine {
    private boolean activeTracker;
    public boolean isActiveTracker(){
        return activeTracker;
    }
    public void action(){
        if (isActiveTracker()){
            System.out.println("Двигатель уже запущен");
        }else {
            start();
        }
    }
    public void start(){
        System.out.println("Двигатель запущен");
        activeTracker= true;
    }
}
