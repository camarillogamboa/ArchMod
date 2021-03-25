package arch.math;

import arch.math.operator.*;
import arch.tools.function.*;

import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

public interface MathArray {

    ByteReductor BYTE_ADDER = a -> ByteReductor.reduce((byte) 0, ByteArithmetic.SUM, a);
    ShortReductor SHORT_ADDER = a -> ShortReductor.reduce((short) 0, ShortArithmetic.SUM, a);
    IntReductor INT_ADDER = a -> IntReductor.reduce(0, IntArithmetic.SUM, a);
    LongReductor LONG_ADDER = a -> LongReductor.reduce(0, LongArithmetic.SUM, a);
    FloatReductor FLOAT_ADDER = a -> FloatReductor.reduce(0, FloatArithmetic.SUM, a);
    DoubleReductor DOUBLE_ADDER = a -> DoubleReductor.reduce(0, DoubleArithmetic.SUM, a);

    ByteReductor BYTE_MULTIPLIER = a -> ByteReductor.reduce((byte) 1, ByteArithmetic.MUL, a);
    ShortReductor SHORT_MULTIPLIER = a -> ShortReductor.reduce((short) 1, ShortArithmetic.MUL, a);
    IntReductor INT_MULTIPLIER = a -> IntReductor.reduce(1, IntArithmetic.MUL, a);
    LongReductor LONG_MULTIPLIER = a -> LongReductor.reduce(1, LongArithmetic.MUL, a);
    FloatReductor FLOAT_MULTIPLIER = a -> FloatReductor.reduce(1, FloatArithmetic.MUL, a);
    DoubleReductor DOUBLE_MULTIPLIER = a -> DoubleReductor.reduce(1, DoubleArithmetic.MUL, a);

    BiFunction<byte[], ByteUnaryOperator, byte[]> BYTE_MAPPER = (d, o) -> {
        var c = new byte[d.length];
        for (int i = 0; i < c.length; i++) c[i] = o.applyAsByte(d[i]);
        return c;
    };

    BiFunction<short[], ShortUnaryOperator, short[]> SHORT_MAPPER = (d, o) -> {
        var c = new short[d.length];
        for (int i = 0; i < c.length; i++) c[i] = o.applyAsShort(d[i]);
        return c;
    };

    BiFunction<int[], IntUnaryOperator, int[]> INT_MAPPER = (d, o) -> {
        var c = new int[d.length];
        for (int i = 0; i < c.length; i++) c[i] = o.applyAsInt(d[i]);
        return c;
    };

    BiFunction<long[], LongUnaryOperator, long[]> LONG_MAPPER = (d, o) -> {
        var c = new long[d.length];
        for (int i = 0; i < c.length; i++) c[i] = o.applyAsLong(d[i]);
        return c;
    };

    BiFunction<float[], FloatUnaryOperator, float[]> FLOAT_MAPPER = (d, o) -> {
        var c = new float[d.length];
        for (int i = 0; i < c.length; i++) c[i] = o.applyAsFloat(d[i]);
        return c;
    };

    BiFunction<double[], DoubleUnaryOperator, double[]> DOUBLE_MAPPER = (d, o) -> {
        var c = new double[d.length];
        for (int i = 0; i < c.length; i++) c[i] = o.applyAsDouble(d[i]);
        return c;
    };

}
