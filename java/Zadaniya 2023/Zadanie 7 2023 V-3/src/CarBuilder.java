public abstract class CarBuilder {
    Car car;

    public void CarBuilder() {
        car = new Car();
    }
    abstract public void buildBrand(String brand);
    abstract public void buildModel(String model);
    abstract public void buildColor(String color);

    Car getCar(){
        return car;
    }

}
