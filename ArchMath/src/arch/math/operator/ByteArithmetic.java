package arch.math.operator;

import arch.tools.function.ByteBinaryOperator;

public interface ByteArithmetic extends ByteBinaryOperator {

    /**
     * Función suma.
     */
    ByteArithmetic SUM = (x, y) -> (byte) (x + y);

    /**
     * Función sustracción.
     */
    ByteArithmetic SUB = (x, y) -> (byte) (x - y);

    /**
     * Función multiplicación.
     */
    ByteArithmetic MUL = (x, y) -> (byte) (x * y);

    /**
     * Función división.
     */
    ByteArithmetic DIV = (x, y) -> (byte) (x / y);

    /**
     * Función porcentaje.
     */
    ByteArithmetic PER = (x, y) -> (byte) (y / 100 * x);

    /**
     * Función potencia.
     */
    ByteArithmetic POW = (a, b) -> (byte) StrictMath.pow(a, b);

    /**
     * Función máximo
     */
    ByteArithmetic MAX = (a, b) -> (byte) Math.max(a, b);

    /**
     * Función mínimo
     */
    ByteArithmetic MIN = (a, b) -> (byte) Math.min(a, b);
}
