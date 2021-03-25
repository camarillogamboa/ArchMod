package arch.tools.collection.collector;

import arch.tools.collection.array.FloatArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.FloatFiller;
import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyFloatProperty;

import java.util.LinkedList;
import java.util.List;

public final class FloatCollector implements FloatFiller {

    private final BasicQueue<ReadOnlyFloatProperty> queue;

    public FloatCollector(float... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(float value) {
        queue.add(Properties.readOnlyProperty(value));
    }

    public List<Float> asList() {
        var list = new LinkedList<Float>();
        queue.forEach(p -> list.add(p.get()));
        return list;
    }

    public float[] asArray() {
        var array = new float[queue.size()];

        var filler = new FloatArrayFiller(array);

        queue.forEach(p -> filler.put(p.get()));

        return array;
    }

}
