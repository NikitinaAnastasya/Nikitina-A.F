package Other;

public abstract class Device {
    public OC oc;

    public Device(OC oc) {
        this.oc = oc;
    }
    public abstract void print();
}
