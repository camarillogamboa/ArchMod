package arch.tools.collection.array;

import java.util.function.Function;
import java.util.function.IntFunction;

/**
 *
 */
public final class Arrays {

    private Arrays() {}

    public static ByteArrayFiller filler(byte[] array) {
        return new ByteArrayFiller(array);
    }

    public static ShortArrayFiller filler(short[] array) {
        return new ShortArrayFiller(array);
    }

    public static IntArrayFiller filler(int[] array) {
        return new IntArrayFiller(array);
    }

    public static LongArrayFiller filler(long[] array) {
        return new LongArrayFiller(array);
    }

    public static FloatArrayFiller filler(float[] array) {
        return new FloatArrayFiller(array);
    }

    public static DoubleArrayFiller filler(double[] array) {
        return new DoubleArrayFiller(array);
    }

    public static CharArrayFiller filler(char[] array) {
        return new CharArrayFiller(array);
    }

    public static BooleanArrayFiller filler(boolean[] array) {
        return new BooleanArrayFiller(array);
    }

    public static <E> ReferenceArrayFiller<E> filler(E[] array) {
        return new ReferenceArrayFiller<>(array);
    }

    public static ReadOnlyByteArray readOnlyArray(byte... array) {
        return new ReadOnlyByteArray(array);
    }

    public static ReadOnlyShortArray readOnlyArray(short... array) {
        return new ReadOnlyShortArray(array);
    }

    public static ReadOnlyIntArray readOnlyArray(int... array) {
        return new ReadOnlyIntArray(array);
    }

    public static ReadOnlyLongArray readOnlyArray(long... array) {
        return new ReadOnlyLongArray(array);
    }

    public static ReadOnlyFloatArray readOnlyArray(float... array) {
        return new ReadOnlyFloatArray(array);
    }

    public static ReadOnlyDoubleArray readOnlyArray(double... array) {
        return new ReadOnlyDoubleArray(array);
    }

    public static ReadOnlyCharArray readOnlyArray(char... array) {
        return new ReadOnlyCharArray(array);
    }

    public static ReadOnlyBooleanArray readOnlyArray(boolean... array) {
        return new ReadOnlyBooleanArray(array);
    }

    public static <E> ReadOnlyReferenceArray<E> readOnlyArray(E... array) {
        return new ReadOnlyReferenceArray<>(array);
    }

    public static <I, O> O[] mapEach(Function<I, O> function, IntFunction<O[]> factory, I... array) {
        var newArray = factory.apply(array.length);
        for (int i = 0; i < newArray.length; i++) newArray[i] = function.apply(array[i]);
        return newArray;
    }

}
