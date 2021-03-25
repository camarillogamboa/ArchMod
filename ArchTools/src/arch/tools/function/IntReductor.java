package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

import java.util.function.IntBinaryOperator;

@FunctionalInterface
public interface IntReductor {

    int reduce(int... a);

    static int reduce(int identity, IntBinaryOperator operator, int... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.applyAsInt(v, b)), elements);
        return property.get();
    }

}
