package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

@FunctionalInterface
public interface FloatReductor {

    float reduce(float... a);

    static float reduce(float identity, FloatBinaryOperator operator, float... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.applyAsFloat(v, b)), elements);
        return property.get();
    }

}
