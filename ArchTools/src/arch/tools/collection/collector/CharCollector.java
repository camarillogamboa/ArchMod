package arch.tools.collection.collector;

import arch.tools.collection.array.CharArrayFiller;
import arch.tools.collection.basic.BasicQueue;
import arch.tools.collection.filler.CharFiller;
import arch.tools.property.ReadOnlyCharProperty;

import java.util.LinkedList;
import java.util.List;

public final class CharCollector implements CharFiller {

    private final BasicQueue<ReadOnlyCharProperty> queue;

    public CharCollector(char... values) {
        this.queue = new BasicQueue<>();
        putAll(values);
    }

    @Override
    public void put(char value) {
        queue.add(new ReadOnlyCharProperty(value));
    }

    public List<Character> asList() {
        var list = new LinkedList<Character>();
        queue.forEach(p -> list.add(p.get()));
        return list;
    }

    public char[] asArray() {
        var array = new char[queue.size()];

        var filler = new CharArrayFiller(array);

        queue.forEach(p -> filler.put(p.get()));

        return array;
    }

}
