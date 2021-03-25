package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

import java.util.function.DoubleBinaryOperator;

@FunctionalInterface
public interface DoubleReductor {

    double reduce(double... a);

    static double reduce(double identity, DoubleBinaryOperator operator, double... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.applyAsDouble(v, b)), elements);
        return property.get();
    }

}
