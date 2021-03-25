package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

@FunctionalInterface
public interface BooleanReductor {

    boolean reduce(boolean... a);

    static boolean reduce(boolean identity, BooleanBinaryOperator operator, boolean... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.applyAsBoolean(v, b)), elements);
        return property.get();
    }

}
