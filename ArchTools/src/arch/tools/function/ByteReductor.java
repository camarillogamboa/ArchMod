package arch.tools.function;

import arch.tools.collection.iterator.Iterators;
import arch.tools.property.Properties;

@FunctionalInterface
public interface ByteReductor {

    byte reduce(byte... a);

    static byte reduce(byte identity, ByteBinaryOperator operator, byte... elements) {
        var property = Properties.property(identity);
        Iterators.iterate(b -> property.map(v -> operator.applyAsByte(v, b)), elements);
        return property.get();
    }

}
