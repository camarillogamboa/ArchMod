package arch.tools.collection.array;

import java.util.function.Function;
import java.util.function.IntFunction;

/**
 *
 */
public final class Arrays {

    private Arrays() {
    }

    public static ByteArrayFiller fillerOf(byte[] array) {
        return new ByteArrayFiller(array);
    }

    public static ShortArrayFiller fillerOf(short[] array) {
        return new ShortArrayFiller(array);
    }

    public static IntArrayFiller fillerOf(int[] array) {
        return new IntArrayFiller(array);
    }

    public static LongArrayFiller fillerOf(long[] array) {
        return new LongArrayFiller(array);
    }

    public static FloatArrayFiller fillerOf(float[] array) {
        return new FloatArrayFiller(array);
    }

    public static DoubleArrayFiller fillerOf(double[] array) {
        return new DoubleArrayFiller(array);
    }

    public static CharArrayFiller fillerOf(char[] array) {
        return new CharArrayFiller(array);
    }

    public static BooleanArrayFiller fillerOf(boolean[] array) {
        return new BooleanArrayFiller(array);
    }

    public static <E> ReferenceArrayFiller<E> fillerOf(E[] array) {
        return new ReferenceArrayFiller<>(array);
    }

    public static ReadOnlyByteArray readOnlyArrayOf(byte... array) {
        return new ReadOnlyByteArray(array);
    }

    public static ReadOnlyShortArray readOnlyArrayOf(short... array) {
        return new ReadOnlyShortArray(array);
    }

    public static ReadOnlyIntArray readOnlyArrayOf(int... array) {
        return new ReadOnlyIntArray(array);
    }

    public static ReadOnlyLongArray readOnlyArrayOf(long... array) {
        return new ReadOnlyLongArray(array);
    }

    public static ReadOnlyFloatArray readOnlyArrayOf(float... array) {
        return new ReadOnlyFloatArray(array);
    }

    public static ReadOnlyDoubleArray readOnlyArrayOf(double... array) {
        return new ReadOnlyDoubleArray(array);
    }

    public static ReadOnlyCharArray readOnlyArrayOf(char... array) {
        return new ReadOnlyCharArray(array);
    }

    public static ReadOnlyBooleanArray readOnlyArrayOf(boolean... array) {
        return new ReadOnlyBooleanArray(array);
    }

    public static ByteArray arrayOf(byte[] array) {
        return new ByteArray(array);
    }

    public static ShortArray arrayOf(short[] array) {
        return new ShortArray(array);
    }

    public static IntArray arrayOf(int[] array) {
        return new IntArray(array);
    }

    public static LongArray arrayOf(long[] array) {
        return new LongArray(array);
    }

    public static FloatArray arrayOf(float[] array) {
        return new FloatArray(array);
    }

    public static DoubleArray arrayOf(double[] array) {
        return new DoubleArray(array);
    }

    public static CharArray arrayOf(char[] array) {
        return new CharArray(array);
    }

    public static BooleanArray arrayOf(boolean[] array) {
        return new BooleanArray(array);
    }

    public static <E> ReferenceArray<E> arrayOf(E[] array) {
        return new ReferenceArray<>(array);
    }

    public static <E> ReadOnlyReferenceArray<E> readOnlyArrayOf(E... array) {
        return new ReadOnlyReferenceArray<>(array);
    }

    public static ByteArray newArrayOf(byte[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static ShortArray newArrayOf(short[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static IntArray newArrayOf(int[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static LongArray newArrayOf(long[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static FloatArray newArrayOf(float[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static DoubleArray newArrayOf(double[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static CharArray newArrayOf(char[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static BooleanArray newArrayOf(boolean[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static <E> ReferenceArray<E> newArrayOf(E[] array) {
        return arrayOf(duplicateArray(array));
    }

    public static void arrayCopy(byte[] a, byte[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static void arrayCopy(short[] a, short[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static void arrayCopy(int[] a, int[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static void arrayCopy(long[] a, long[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static void arrayCopy(float[] a, float[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static void arrayCopy(double[] a, double[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static void arrayCopy(char[] a, char[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static void arrayCopy(boolean[] a, boolean[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static <T> void arrayCopy(T[] a, T[] b) {
        System.arraycopy(a, 0, b, 0, b.length);
    }

    public static byte[] duplicateArray(byte[] array) {
        var newArray = new byte[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static short[] duplicateArray(short[] array) {
        var newArray = new short[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static int[] duplicateArray(int[] array) {
        var newArray = new int[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static long[] duplicateArray(long[] array) {
        var newArray = new long[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static float[] duplicateArray(float[] array) {
        var newArray = new float[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static double[] duplicateArray(double[] array) {
        var newArray = new double[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static char[] duplicateArray(char[] array) {
        var newArray = new char[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static boolean[] duplicateArray(boolean[] array) {
        var newArray = new boolean[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static <E> E[] duplicateArray(E[] array) {
        var newArray = (E[]) new Object[array.length];
        arrayCopy(array, newArray);
        return newArray;
    }

    public static <I, O> O[] mapEach(Function<I, O> function, IntFunction<O[]> factory, I... array) {
        var newArray = factory.apply(array.length);
        for (int i = 0; i < newArray.length; i++) newArray[i] = function.apply(array[i]);
        return newArray;
    }

    public static int forceIndex(int length, int index) {
        return index < 0 ? length + index : index;
    }

}
