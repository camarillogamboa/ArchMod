package arch.math.operator;

import arch.tools.function.ShortBinaryOperator;

public interface ShortArithmetic extends ShortBinaryOperator {

    /**
     * Función suma.
     */
    ShortArithmetic SUM = (x, y) -> (short) (x + y);

    /**
     * Función sustracción.
     */
    ShortArithmetic SUB = (x, y) -> (short) (x - y);

    /**
     * Función multiplicación.
     */
    ShortArithmetic MUL = (x, y) -> (short) (x * y);

    /**
     * Función división.
     */
    ShortArithmetic DIV = (x, y) -> (short) (x / y);

    /**
     * Función porcentaje.
     */
    ShortArithmetic PER = (x, y) -> (short) (y / 100 * x);

    /**
     * Función potencia.
     */
    ShortArithmetic POW = (a, b) -> (short) StrictMath.pow(a, b);

    /**
     * Función máximo
     */
    ShortArithmetic MAX = (a, b) -> (short) Math.max(a, b);

    /**
     * Función mínimo
     */
    ShortArithmetic MIN = (a, b) -> (short) Math.min(a, b);

}
