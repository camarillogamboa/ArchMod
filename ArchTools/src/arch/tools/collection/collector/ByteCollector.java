package arch.tools.collection.collector;

import arch.tools.collection.array.ByteArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.ByteFiller;
import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyByteProperty;

import java.util.LinkedList;
import java.util.List;

public final class ByteCollector implements ByteFiller {

    private final BasicQueue<ReadOnlyByteProperty> queue;

    public ByteCollector(byte... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(byte value) {
        queue.add(Properties.readOnlyProperty(value));
    }

    public List<Byte> asList() {
        var list = new LinkedList<Byte>();
        queue.forEach(p -> list.add(p.get()));
        return list;
    }

    public byte[] asArray() {
        var array = new byte[queue.size()];

        var filler = new ByteArrayFiller(array);

        queue.forEach(p -> filler.put(p.get()));

        return array;
    }

}
