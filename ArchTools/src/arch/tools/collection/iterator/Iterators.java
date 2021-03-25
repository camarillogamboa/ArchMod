package arch.tools.collection.iterator;

import arch.tools.function.*;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/**
 * Clase fábrica de iteradores y utilidades para iterar elementos
 */
public final class Iterators {

    /**
     * No es posible crear instancias de esta clase
     */
    private Iterators() {
    }

    public static ByteIterator iterator(byte... array) {
        return new IndexedByteIterator(array.length, i -> array[i]);
    }

    public static ShortIterator iterator(short... array) {
        return new IndexedShortIterator(array.length, i -> array[i]);
    }

    public static IntIterator iterator(int... array) {
        return new IndexedIntIterator(array.length, i -> array[i]);
    }

    public static LongIterator iterator(long... array) {
        return new IndexedLongIterator(array.length, i -> array[i]);
    }

    public static FloatIterator iterator(float... array) {

        return new IndexedFloatIterator(array.length, i -> array[i]);
    }

    public static DoubleIterator iterator(double... array) {
        return new IndexedDoubleIterator(array.length, i -> array[i]);
    }

    public static CharIterator iterator(char... array) {
        return new IndexedCharIterator(array.length, i -> array[i]);
    }

    public static BooleanIterator iterator(boolean... array) {
        return new IndexedBooleanIterator(array.length, i -> array[i]);
    }

    @SafeVarargs
    public static <E> Iterator<E> iterator(E... array) {
        return new IndexedIterator<>(array.length, i -> array[i]);
    }

    public static CharIterator iterator(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        return new IndexedCharIterator(charSequence.length(), charSequence::charAt);
    }

    public static void iterate(ByteConsumer consumer, byte... elements) {
        iterate(iterator(elements), consumer);
    }

    public static void iterate(ShortConsumer consumer, short... elements) {
        iterate(iterator(elements), consumer);
    }

    public static void iterate(IntConsumer consumer, int... elements) {
        iterate(iterator(elements), consumer);
    }

    public static void iterate(LongConsumer consumer, long... elements) {
        iterate(iterator(elements), consumer);
    }

    public static void iterate(FloatConsumer consumer, float... elements) {
        iterate(iterator(elements), consumer);
    }

    public static void iterate(DoubleConsumer consumer, double... elements) {
        iterate(iterator(elements), consumer);
    }

    public static void iterate(CharConsumer consumer, char... elements) {
        iterate(iterator(elements), consumer);
    }

    public static void iterate(BooleanConsumer consumer, boolean... elements) {
        iterate(iterator(elements), consumer);
    }

    @SafeVarargs
    public static <E> void iterate(Consumer<E> consumer, E... elements) {
        iterate(iterator(elements), consumer);
    }

    public static void iterate(ByteIterator iterator, ByteConsumer consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static void iterate(ShortIterator iterator, ShortConsumer consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static void iterate(IntIterator iterator, IntConsumer consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static void iterate(LongIterator iterator, LongConsumer consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static void iterate(FloatIterator iterator, FloatConsumer consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static void iterate(DoubleIterator iterator, DoubleConsumer consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static void iterate(CharIterator iterator, CharConsumer consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static void iterate(BooleanIterator iterator, BooleanConsumer consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static <T> void iterate(Iterator<T> iterator, Consumer<T> consumer) {
        Objects.requireNonNull(iterator);
        Objects.requireNonNull(consumer);
        while (iterator.hasNext()) consumer.accept(iterator.next());
    }

    public static void iterate(CharSequence charSequence, CharConsumer consumer) {
        iterate(iterator(charSequence), consumer);
    }

    public static ByteCursor cursor(ByteIterator iterator) {
        return new ByteCursor(iterator);
    }

    public static ShortCursor cursor(ShortIterator iterator) {
        return new ShortCursor(iterator);
    }

    public static IntCursor cursor(IntIterator iterator) {
        return new IntCursor(iterator);
    }

    public static LongCursor cursor(LongIterator iterator) {
        return new LongCursor(iterator);
    }

    public static FloatCursor cursor(FloatIterator iterator) {
        return new FloatCursor(iterator);
    }

    public static DoubleCursor cursor(DoubleIterator iterator) {
        return new DoubleCursor(iterator);
    }

    public static CharCursor cursor(CharIterator iterator) {
        return new CharCursor(iterator);
    }

    public static BooleanCursor cursor(BooleanIterator iterator) {
        return new BooleanCursor(iterator);
    }

    public static <E> Cursor<E> cursor(Iterator<E> iterator) {
        return new Cursor<>(iterator);
    }

    public static BytePointer pointer(ByteIterator iterator) {
        return new BytePointer(iterator);
    }

    public static ShortPointer pointer(ShortIterator iterator) {
        return new ShortPointer(iterator);
    }

    public static IntPointer pointer(IntIterator iterator) {
        return new IntPointer(iterator);
    }

    public static LongPointer pointer(LongIterator iterator) {
        return new LongPointer(iterator);
    }

    public static FloatPointer pointer(FloatIterator iterator) {
        return new FloatPointer(iterator);
    }

    public static DoublePointer pointer(DoublePointer iterator) {
        return new DoublePointer(iterator);
    }

    public static CharPointer pointer(CharIterator iterator) {
        return new CharPointer(iterator);
    }

    public static BooleanPointer pointer(BooleanIterator iterator) {
        return new BooleanPointer(iterator);
    }

    public static <E> Pointer<E> pointer(Iterator<E> iterator) {
        return new Pointer<>(iterator);
    }

}
