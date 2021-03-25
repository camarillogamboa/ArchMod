package arch.math.numericalsystems;

import arch.tools.collection.iterator.CharIterator;

public interface NumericLiteral {

    String getLiteral();

    double decimalValue();

    default CharIterator iterator() {
        return null;
    }

}
