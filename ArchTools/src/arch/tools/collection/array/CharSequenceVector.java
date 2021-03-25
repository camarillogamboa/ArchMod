package arch.tools.collection.array;

import arch.tools.collection.iterator.CharIterator;
import arch.tools.collection.iterator.Iterators;

import java.util.Objects;

public final class CharSequenceVector implements ReadOnlyCharVector {

    private final CharSequence charSequence;

    public CharSequenceVector(CharSequence charSequence) {
        this.charSequence = Objects.requireNonNull(charSequence);
    }

    @Override
    public int size() {
        return charSequence.length();
    }

    @Override
    public char valueOf(int index) {
        return charSequence.charAt(index);
    }

    @Override
    public CharIterator iterator() {
        return Iterators.iterator(charSequence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (CharSequenceVector) o;
        return Objects.equals(charSequence, that.charSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charSequence);
    }
}
