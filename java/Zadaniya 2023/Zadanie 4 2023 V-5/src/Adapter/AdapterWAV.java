package Adapter;

import Format.WAV;
import Interface.Actions;

public class AdapterWAV extends WAV implements Actions {
    @Override
    public void reproduce() {
        reproduceFile();
    }
}
