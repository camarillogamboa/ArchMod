package arch.tools.collection.collector;

import arch.tools.collection.array.IntArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.IntFiller;
import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyIntProperty;

import java.util.LinkedList;
import java.util.List;

public final class IntCollector implements IntFiller {

    private final BasicQueue<ReadOnlyIntProperty> queue;

    public IntCollector(int... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(int value) {
        queue.add(Properties.readOnlyProperty(value));
    }

    public List<Integer> asList() {
        var list = new LinkedList<Integer>();
        queue.forEach(p -> list.add(p.get()));
        return list;
    }

    public int[] asArray() {
        var array = new int[queue.size()];

        var filler = new IntArrayFiller(array);

        queue.forEach(p -> filler.put(p.get()));

        return array;
    }
}
