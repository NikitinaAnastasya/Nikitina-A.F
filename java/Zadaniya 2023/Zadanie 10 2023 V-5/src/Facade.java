import Auto.Climate;
import Auto.Engine;
import Auto.Music;

public class Facade {
    Climate climate = new Climate();
    Engine engine = new Engine();
    Music music = new Music();

    public void setEngine(){
        engine.action();
    }
    public void setClimate(String degrees){
        climate.setDegrees(degrees);
        climate.show();
    }
    public void setMusic(){
        music.action();
    }

}
