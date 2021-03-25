package arch.math.operator;

import java.util.function.DoubleBinaryOperator;

public interface DoubleArithmetic extends DoubleBinaryOperator {

    /**
     * Función suma.
     */
    DoubleArithmetic SUM = Double::sum;

    /**
     * Función sustracción.
     */
    DoubleArithmetic SUB = (x, y) -> x - y;

    /**
     * Función multiplicación.
     */
    DoubleArithmetic MUL = (x, y) -> x * y;

    /**
     * Función división.
     */
    DoubleArithmetic DIV = (x, y) -> x / y;

    /**
     * Función porcentaje.
     */
    DoubleArithmetic PER = (x, y) -> y / 100 * x;

    /**
     * Función potencia.
     */
    DoubleArithmetic POW = StrictMath::pow;

    /**
     * Función máximo
     */
    DoubleArithmetic MAX = Math::max;

    /**
     * Función mínimo
     */
    DoubleArithmetic MIN = Math::min;

}
