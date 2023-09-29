package Devices;

import Other.Device;
import Other.OC;

public class Laptop extends Device {
    public Laptop(OC oc) {
        super(oc);
    }

    @Override
    public void print() {
        oc.show("Ноутбук -");
    }
}
