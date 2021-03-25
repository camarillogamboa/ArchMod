package arch.tools.collection;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class StreamFactory {

    private StreamFactory() {}

    public static <T> Stream<T> streamOf(Iterator<T> iterator) {
        int characteristics = Spliterator.ORDERED | Spliterator.NONNULL;
        var spliterator = Spliterators.spliteratorUnknownSize(iterator, characteristics);
        return StreamSupport.stream(spliterator, false);
    }

}
