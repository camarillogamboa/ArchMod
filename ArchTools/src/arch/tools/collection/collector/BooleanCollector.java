package arch.tools.collection.collector;

import arch.tools.collection.array.BooleanArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.BooleanFiller;
import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyBooleanProperty;

import java.util.LinkedList;
import java.util.List;

public final class BooleanCollector implements BooleanFiller {

    private final BasicQueue<ReadOnlyBooleanProperty> queue;

    public BooleanCollector(boolean... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(boolean value) {
        queue.add(Properties.readOnlyProperty(value));
    }

    public List<Boolean> asList() {
        var list = new LinkedList<Boolean>();
        queue.forEach(p -> list.add(p.get()));
        return list;
    }

    public boolean[] asArray() {
        var array = new boolean[queue.size()];

        var filler = new BooleanArrayFiller(array);

        queue.forEach(p -> filler.put(p.get()));

        return array;
    }

}
