package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

@FunctionalInterface
public interface ShortReductor {

    short reduce(short... a);

    static short reduce(short identity, ShortBinaryOperator operator, short... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.applyAsShort(v, b)), elements);
        return property.get();
    }

}
