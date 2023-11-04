package Classic;

import Interface.Chair;
import Interface.Closet;
import Interface.FurnFactory;
import Interface.Table;

public class ClassicFactory implements FurnFactory {
    @Override
    public Chair getChair() {
        return new ClassicChair();
    }

    @Override
    public Closet getCloset() {
        return new ClassicCloset();
    }

    @Override
    public Table getTable() {
        return new ClassicTable();
    }
}
