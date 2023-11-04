package Devices;

import Other.Device;
import Other.OC;

public class Tablet extends Device {
    public Tablet(OC oc) {
        super(oc);
    }

    @Override
    public void print() {
        oc.show("Планшет -");
    }
}
