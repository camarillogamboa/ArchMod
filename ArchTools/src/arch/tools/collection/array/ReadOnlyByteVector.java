package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.ByteIterable;

public interface ReadOnlyByteVector extends ByteIterable, Sizable {

    byte valueOf(int index);

    default byte[] toArray() {
        return Arrays.fillerOf(new byte[size()]).fillRemaining(this::valueOf);
    }

}
