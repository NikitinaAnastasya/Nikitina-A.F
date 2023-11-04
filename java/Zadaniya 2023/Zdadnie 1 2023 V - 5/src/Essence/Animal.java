package Essence;

public class Animal {
    private final String type;
    private final String name;
    private final String floor;
    private String move;
    private final String nutrition;

    public Animal(String type, String name, String floor, String move, String nutrition) {
        this.type = type;
        this.name = name;
        this.floor = floor;
        this.move = move;
        this.nutrition = nutrition;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getFloor() {
        return floor;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getNutrition() {
        return nutrition;
    }

}
