package arch.tools.collection.collector;

import arch.tools.collection.array.ReferenceArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.ReferenceFiller;

import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;


public final class ReferenceCollector<E> implements ReferenceFiller<E> {

    private final BasicQueue<E> queue;

    public ReferenceCollector(E... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(E value) {
        queue.add(value);
    }

    public List<E> asList() {
        var list = new LinkedList<E>();
        queue.forEach(list::add);
        return list;
    }

    public E[] asArray(IntFunction<E[]> factory) {
        var array = factory.apply(queue.size());

        var filler = new ReferenceArrayFiller<E>(array);

        queue.forEach(filler::put);

        return array;
    }
}
