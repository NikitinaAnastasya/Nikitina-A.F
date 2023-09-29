package Devices;

import Other.Device;
import Other.OC;

public class Telephone extends Device {
    public Telephone(OC oc) {
        super(oc);
    }

    @Override
    public void print() {
        oc.show("Телефон -");
    }
}
