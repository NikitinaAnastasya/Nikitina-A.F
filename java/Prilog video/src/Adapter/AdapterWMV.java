package Adapter;

import Format.WMV;
import Interface.Actions;

public class AdapterWMV extends WMV implements Actions {
    @Override
    public void reproduce() {
        reproduceFile();
    }
}
