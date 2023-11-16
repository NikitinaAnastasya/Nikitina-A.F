public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.setEngine();
        facade.setClimate("23");
        facade.setMusic();
        facade.music.switching();
    }
}