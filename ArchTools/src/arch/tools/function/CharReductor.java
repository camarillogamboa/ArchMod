package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

@FunctionalInterface
public interface CharReductor {

    char reduce(char... a);

    static char reduce(char identity, CharBinaryOperator operator, char... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.applyAsChar(v, b)), elements);
        return property.get();
    }

}
