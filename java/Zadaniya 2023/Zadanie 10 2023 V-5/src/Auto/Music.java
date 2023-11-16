package Auto;

public class Music {
    private boolean activeTracker;
    public boolean isActiveTracker(){
        return activeTracker;
    }
    public void action(){
        if (isActiveTracker()) {
            stop();
        }else {
            start();
        }
    }
    public void start(){
        System.out.println("Музыка включена");
        activeTracker = true;
    }
    public void stop(){
        System.out.println("Музыка выключена");
        activeTracker = false;
    }
    public void switching(){
        if (isActiveTracker()){
            System.out.println("Следующая песня");
        }else {
            System.out.println("Для начала включите музыку");
        }
    }
}
