package arch.tools.collection.collector;

import arch.tools.collection.array.DoubleArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.DoubleFiller;
import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyDoubleProperty;

import java.util.LinkedList;
import java.util.List;

public final class DoubleCollector implements DoubleFiller {

    private final BasicQueue<ReadOnlyDoubleProperty> queue;

    public DoubleCollector(double... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(double value) {
        queue.add(Properties.readOnlyProperty(value));
    }

    public List<Double> asList() {
        var list = new LinkedList<Double>();
        queue.forEach(p -> list.add(p.get()));
        return list;
    }

    public double[] asArray() {
        var array = new double[queue.size()];

        var filler = new DoubleArrayFiller(array);

        queue.forEach(p -> filler.put(p.get()));

        return array;
    }
}
