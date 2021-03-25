package arch.tools.collection.iterator;

import java.util.Objects;

public final class CharCursor implements CharIterator {

    private final CharIterator charIterator;

    private char currentValue;

    public CharCursor(CharIterator charIterator) {
        this.charIterator = Objects.requireNonNull(charIterator);
    }

    @Override
    public boolean hasNext() {
        return charIterator.hasNext();
    }

    public char getCurrentValue() {
        return currentValue;
    }

    @Override
    public char next() {
        return currentValue = charIterator.next();
    }

}
