package arch.tools.collection.collector;

import arch.tools.collection.array.LongArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.LongFiller;
import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyLongProperty;

import java.util.LinkedList;
import java.util.List;

public final class LongCollector implements LongFiller {

    private final BasicQueue<ReadOnlyLongProperty> queue;

    public LongCollector(long... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(long value) {
        queue.add(Properties.readOnlyProperty(value));
    }

    public List<Long> asList() {
        var list = new LinkedList<Long>();
        queue.forEach(p -> list.add(p.get()));
        return list;
    }

    public long[] asArray() {
        var array = new long[queue.size()];

        var filler = new LongArrayFiller(array);

        queue.forEach(p -> filler.put(p.get()));

        return array;
    }
}
