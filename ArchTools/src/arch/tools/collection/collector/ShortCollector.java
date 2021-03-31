package arch.tools.collection.collector;

import arch.tools.collection.array.ShortArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.ShortFiller;
import arch.tools.property.ReadOnlyShortProperty;

import java.util.LinkedList;
import java.util.List;

public final class ShortCollector implements ShortFiller {

    private final BasicQueue<ReadOnlyShortProperty> queue;

    public ShortCollector(short... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(short value) {
        queue.add(new ReadOnlyShortProperty(value));
    }

    public List<Short> asList() {
        var list = new LinkedList<Short>();
        queue.forEach(p -> list.add(p.get()));
        return list;
    }

    public short[] asArray() {
        var array = new short[queue.size()];

        var filler = new ShortArrayFiller(array);

        queue.forEach(p -> filler.put(p.get()));

        return array;
    }

}
