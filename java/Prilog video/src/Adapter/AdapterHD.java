package Adapter;

import Format.HD;

import Interface.Actions;

public class AdapterHD extends HD implements Actions {
    @Override
    public void reproduce() {
        reproduceFile();
    }
}
