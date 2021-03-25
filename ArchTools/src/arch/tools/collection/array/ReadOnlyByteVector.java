package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.ByteIterable;

public interface ReadOnlyByteVector extends ByteIterable, Sizable {

    byte valueOf(int index);

    default byte[] toArray() {
        var array = new byte[size()];
        Arrays.filler(array).fillRemaining(this::valueOf);
        return array;
    }

}
