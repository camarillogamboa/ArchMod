package arch.math.operator;

import java.util.function.LongBinaryOperator;

public interface LongArithmetic extends LongBinaryOperator {

    /**
     * Función suma.
     */
    LongArithmetic SUM = Long::sum;

    /**
     * Función sustracción.
     */
    LongArithmetic SUB = (x, y) -> x - y;

    /**
     * Función multiplicación.
     */
    LongArithmetic MUL = (x, y) -> x * y;

    /**
     * Función división.
     */
    LongArithmetic DIV = (x, y) -> x / y;

    /**
     * Función porcentaje.
     */
    LongArithmetic PER = (x, y) -> y / 100 * x;

    /**
     * Función potencia.
     */
    LongArithmetic POW = (a, b) -> (long) StrictMath.pow(a, b);

    /**
     * Función máximo
     */
    LongArithmetic MAX = Math::max;

    /**
     * Función mínimo
     */
    LongArithmetic MIN = Math::min;
}
