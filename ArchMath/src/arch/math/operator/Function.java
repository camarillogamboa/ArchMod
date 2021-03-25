package arch.math.operator;

import java.util.function.DoubleUnaryOperator;

import static java.lang.StrictMath.*;

@FunctionalInterface
public interface Function extends DoubleUnaryOperator {

    /**
     * Función identidad
     */
    Function IDEN = x -> x;

    /**
     * Función seno.
     */
    Function SIN = StrictMath::sin;

    /**
     * Función coseno.
     */
    Function COS = StrictMath::cos;

    /**
     * Función tangente.
     */
    Function TAN = StrictMath::tan;

    /**
     * Función arcoseno.
     */
    Function ASIN = StrictMath::asin;

    /**
     * Función arcocoseno.
     */
    Function ACOS = StrictMath::acos;

    /**
     * Función arcotangente.
     */
    Function ATAN = StrictMath::atan;

    /**
     * Función cosecante.
     */
    Function CSC = x -> 1 / sin(x);

    /**
     * Función secante.
     */
    Function SEC = x -> 1 / cos(x);

    /**
     * Función cotangente.
     */
    Function COT = x -> 1 / tan(x);

    /**
     * Función seno hiperbólico.
     */
    Function SINH = StrictMath::sinh;

    /**
     * Función coseno hiperbólico.
     */
    Function COSH = StrictMath::cosh;

    /**
     * Función tangente hiperbólica.
     */
    Function TANH = StrictMath::tanh;

    /**
     * Función cosecante hiperbólica.
     */
    Function CSCH = x -> 1 / sinh(x);

    /**
     * Función secante hiperbólica.
     */
    Function SECH = x -> 1 / cosh(x);

    /**
     * Función cotangente hiperbólica.
     */
    Function COTH = x -> cosh(x) / sinh(x);

    /**
     * Función arcoseno hiperbólico.
     */
    Function ASINH = x -> log(x + sqrt(pow(x, 2) + 1));

    /**
     * Función arcocoseno hiperbólico.
     */
    Function ACOSH = x -> log(x + sqrt(pow(x, 2) - 1));

    /**
     * Función arcotangente hiperbólica.
     */
    Function ATANH = x -> log((1 + x) / (1 - x)) / 2;

    /**
     * Función arcocotangente hiperbólica.
     */
    Function ACOTH = x -> log((x + 1) / (x - 1)) / 2;

    /**
     * Función arcosecante hiperbólica.
     */
    Function ASECH = x -> log(1 / x + sqrt(1 - pow(x, 2)) / x);

    /**
     * Función arcocosecante hiperbólica.
     */
    Function ACSCH = x -> log(1 / x + sqrt(1 + pow(x, 2)) / abs(x));

    /**
     * Función logaritmo natural.
     */
    Function LOG = StrictMath::log;

    /**
     * Función logaritmo base 10
     */
    Function LOG_10 = StrictMath::log10;

    /**
     * Función exponencial.
     */
    Function EXP = StrictMath::exp;

    /**
     * Función raiz cuadrada.
     */
    Function SQRT = StrictMath::sqrt;

    /**
     * Función raíz cúbica
     */
    Function CBRT = StrictMath::cbrt;

    /**
     * Función valor absoluto.
     */
    Function ABS = StrictMath::abs;

    /**
     * Función negación.
     */
    Function NEG = x -> -x;

    /**
     * Función inversa.
     */
    Function INV = x -> 1 / x;

    /**
     * Función conversión a radianes.
     */
    Function TO_RADIANS = StrictMath::toRadians;

    /**
     * Función conversión a grados.
     */
    Function TO_DEGREES = StrictMath::toDegrees;

}
