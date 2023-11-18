public class Songs {
    private String name;

    public Songs(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "name='" + name + '\'' +
                '}';
    }
}
