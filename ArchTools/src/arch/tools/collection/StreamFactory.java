package arch.tools.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.*;

public final class StreamFactory {

    private StreamFactory() {
    }

    public static IntStream streamOf(int... integers) {
        return Arrays.stream(integers);
    }

    public static LongStream streamOf(long... longs) {
        return Arrays.stream(longs);
    }

    public static DoubleStream streamOf(double... doubles) {
        return Arrays.stream(doubles);
    }

    public static <T> Stream<T> streamOf(T... elements) {
        return Arrays.stream(elements);
    }

    public static <T> Stream<T> streamOf(Iterator<T> iterator) {
        int characteristics = Spliterator.ORDERED | Spliterator.NONNULL;
        var spliterator = Spliterators.spliteratorUnknownSize(iterator, characteristics);
        return StreamSupport.stream(spliterator, false);
    }

}
