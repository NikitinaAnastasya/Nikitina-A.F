package Minimal;

import Interface.Chair;
import Interface.Closet;
import Interface.FurnFactory;
import Interface.Table;

public class MinimalFactory implements FurnFactory {
    @Override
    public Chair getChair() {
        return new MinimalChair();
    }

    @Override
    public Closet getCloset() {
        return new MinimalCloset();
    }

    @Override
    public Table getTable() {
        return new MinimalTable();
    }
}
