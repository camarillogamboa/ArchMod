package arch.math.operator;

import arch.tools.function.FloatBinaryOperator;

public interface FloatArithmetic extends FloatBinaryOperator {

    /**
     * Función suma.
     */
    FloatArithmetic SUM = Float::sum;

    /**
     * Función sustracción.
     */
    FloatArithmetic SUB = (x, y) -> x - y;

    /**
     * Función multiplicación.
     */
    FloatArithmetic MUL = (x, y) -> x * y;

    /**
     * Función división.
     */
    FloatArithmetic DIV = (x, y) -> x / y;

    /**
     * Función porcentaje.
     */
    FloatArithmetic PER = (x, y) -> y / 100 * x;

    /**
     * Función potencia.
     */
    FloatArithmetic POW = (a, b) -> (float) StrictMath.pow(a, b);

    /**
     * Función máximo
     */
    FloatArithmetic MAX = Math::max;

    /**
     * Función mínimo
     */
    FloatArithmetic MIN = Math::min;
}
