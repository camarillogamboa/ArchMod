package arch.math.operator;

import java.util.function.IntBinaryOperator;

public interface IntArithmetic extends IntBinaryOperator {

    /**
     * Función suma.
     */
    IntArithmetic SUM = Integer::sum;

    /**
     * Función sustracción.
     */
    IntArithmetic SUB = (x, y) -> x - y;

    /**
     * Función multiplicación.
     */
    IntArithmetic MUL = (x, y) -> x * y;

    /**
     * Función división.
     */
    IntArithmetic DIV = (x, y) -> x / y;

    /**
     * Función porcentaje.
     */
    IntArithmetic PER = (x, y) -> y / 100 * x;

    /**
     * Función potencia.
     */
    IntArithmetic POW = (a, b) -> (int) StrictMath.pow(a, b);

    /**
     * Función máximo
     */
    IntArithmetic MAX = Math::max;

    /**
     * Función mínimo
     */
    IntArithmetic MIN = Math::min;

}
