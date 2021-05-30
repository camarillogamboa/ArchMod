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

    public static ByteIterator iteratorOf(byte... array) {
        return new IndexedByteIterator(array.length, i -> array[i]);
    }

    public static ShortIterator iteratorOf(short... array) {
        return new IndexedShortIterator(array.length, i -> array[i]);
    }

    public static IntIterator iteratorOf(int... array) {
        return new IndexedIntIterator(array.length, i -> array[i]);
    }

    public static LongIterator iteratorOf(long... array) {
        return new IndexedLongIterator(array.length, i -> array[i]);
    }

    public static FloatIterator iteratorOf(float... array) {

        return new IndexedFloatIterator(array.length, i -> array[i]);
    }

    public static DoubleIterator iteratorOf(double... array) {
        return new IndexedDoubleIterator(array.length, i -> array[i]);
    }

    public static CharIterator iteratorOf(char... array) {
        return new IndexedCharIterator(array.length, i -> array[i]);
    }

    public static BooleanIterator iteratorOf(boolean... array) {
        return new IndexedBooleanIterator(array.length, i -> array[i]);
    }

    @SafeVarargs
    public static <E> Iterator<E> iteratorOf(E... array) {
        return new IndexedIterator<>(array.length, i -> array[i]);
    }

    public static CharIterator iteratorOf(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        return new IndexedCharIterator(charSequence.length(), charSequence::charAt);
    }

    public static void iterate(ByteConsumer consumer, byte... elements) {
        iterate(iteratorOf(elements), consumer);
    }

    public static void iterate(ShortConsumer consumer, short... elements) {
        iterate(iteratorOf(elements), consumer);
    }

    public static void iterate(IntConsumer consumer, int... elements) {
        iterate(iteratorOf(elements), consumer);
    }

    public static void iterate(LongConsumer consumer, long... elements) {
        iterate(iteratorOf(elements), consumer);
    }

    public static void iterate(FloatConsumer consumer, float... elements) {
        iterate(iteratorOf(elements), consumer);
    }

    public static void iterate(DoubleConsumer consumer, double... elements) {
        iterate(iteratorOf(elements), consumer);
    }

    public static void iterate(CharConsumer consumer, char... elements) {
        iterate(iteratorOf(elements), consumer);
    }

    public static void iterate(BooleanConsumer consumer, boolean... elements) {
        iterate(iteratorOf(elements), consumer);
    }

    @SafeVarargs
    public static <E> void iterate(Consumer<E> consumer, E... elements) {
        iterate(iteratorOf(elements), consumer);
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
        iterate(iteratorOf(charSequence), consumer);
    }

    public static ByteCursor cursorOf(ByteIterator iterator) {
        return new ByteCursor(iterator);
    }

    public static ShortCursor cursorOf(ShortIterator iterator) {
        return new ShortCursor(iterator);
    }

    public static IntCursor cursorOf(IntIterator iterator) {
        return new IntCursor(iterator);
    }

    public static LongCursor cursorOf(LongIterator iterator) {
        return new LongCursor(iterator);
    }

    public static FloatCursor cursorOf(FloatIterator iterator) {
        return new FloatCursor(iterator);
    }

    public static DoubleCursor cursorOf(DoubleIterator iterator) {
        return new DoubleCursor(iterator);
    }

    public static CharCursor cursorOf(CharIterator iterator) {
        return new CharCursor(iterator);
    }

    public static BooleanCursor cursorOf(BooleanIterator iterator) {
        return new BooleanCursor(iterator);
    }

    public static <E> Cursor<E> cursorOf(Iterator<E> iterator) {
        return new Cursor<>(iterator);
    }

    public static BytePointer pointerOf(ByteIterator iterator) {
        return new BytePointer(iterator);
    }

    public static ShortPointer pointerOf(ShortIterator iterator) {
        return new ShortPointer(iterator);
    }

    public static IntPointer pointerOf(IntIterator iterator) {
        return new IntPointer(iterator);
    }

    public static LongPointer pointerOf(LongIterator iterator) {
        return new LongPointer(iterator);
    }

    public static FloatPointer pointerOf(FloatIterator iterator) {
        return new FloatPointer(iterator);
    }

    public static DoublePointer pointerOf(DoublePointer iterator) {
        return new DoublePointer(iterator);
    }

    public static CharPointer pointerOf(CharIterator iterator) {
        return new CharPointer(iterator);
    }

    public static BooleanPointer pointerOf(BooleanIterator iterator) {
        return new BooleanPointer(iterator);
    }

    public static <E> Pointer<E> pointerOf(Iterator<E> iterator) {
        return new Pointer<>(iterator);
    }

    public static <E> int hashCode(Iterator<E> iterator) {
        if (iterator == null) return 0;

        int result = 1;

        while (iterator.hasNext()) {
            var element = iterator.next();
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }
        return result;
    }

}
