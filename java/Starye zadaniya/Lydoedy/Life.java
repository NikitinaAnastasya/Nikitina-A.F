

public abstract class Life {
    final void day(){
        System.out.println("Расписание дня");

        hunter();

        action();
        cook();


        eat();
        sleep();

    }

    abstract void action();
    ///сделать ее пустой реализацией и не трогать в красном , т е из красного ее убрать

    abstract void cook();

    void sleep() {
        System.out.println("Спать");

    }

    void eat() {
        System.out.println("Есть");
    }

    void hunter() {
        System.out.println("Ловить жертву");
    }
}
