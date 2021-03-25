package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

import java.util.function.LongBinaryOperator;

@FunctionalInterface
public interface LongReductor {

    long reduce(long... a);

    static long reduce(long identity, LongBinaryOperator operator, long... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.applyAsLong(v, b)), elements);
        return property.get();
    }

}
