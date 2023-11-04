package Adapter;

import Format.MP3;
import Interface.Actions;

public class AdapterMP3 extends MP3 implements Actions {
    @Override
    public void reproduce() {
        reproduceFile();
    }
}
