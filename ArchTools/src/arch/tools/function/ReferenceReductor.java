package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

import java.util.function.BinaryOperator;

public interface ReferenceReductor<T> {

    T reduce(T... a);

    @SafeVarargs
    static <T> T reduce(T identity, BinaryOperator<T> operator, T... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.apply(v, b)), elements);
        return property.get();
    }

}
