package Modern;

import Interface.Chair;
import Interface.Closet;
import Interface.FurnFactory;
import Interface.Table;

public class ModernFactory implements FurnFactory {
    @Override
    public Chair getChair() {
        return new ModernChair();
    }

    @Override
    public Closet getCloset() {
        return new ModernCloset();
    }

    @Override
    public Table getTable() {
        return new ModernTable();
    }
}
