package arch.tools.collection.iterator;

import java.util.NoSuchElementException;

public class IndexedIteratorBase implements Sequential {

    protected final IntCursor intCursor;

    public IndexedIteratorBase(int limit) {
        this.intCursor = Iterators.cursor(new IntIterator() {

            int index;

            {
                this.index = 0;
            }

            @Override
            public boolean hasNext() {
                return index < limit;
            }

            @Override
            public int next() {
                if (hasNext()) return index++;
                else throw new NoSuchElementException();
            }
        });
    }

    @Override
    public final boolean hasNext() {
        return intCursor.hasNext();
    }

}
