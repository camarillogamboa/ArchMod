package arch.tools.io.textfile;

import arch.tools.collection.array.CharSequenceVector;
import arch.tools.collection.array.ReadOnlyCharArray;
import arch.tools.collection.array.ReadOnlyCharVector;
import arch.tools.collection.iterator.CharIterable;
import arch.tools.collection.iterator.CharIterator;
import arch.tools.collection.iterator.IndexedCharIterator;
import arch.tools.io.Printable;

import java.io.PrintStream;
import java.util.Objects;

public final class TextState implements CharSequence, CharIterable, Printable {

    private final ReadOnlyCharVector charVector;

    private final int start;
    private final int end;

    private final int length;

    public TextState(ReadOnlyCharVector charVector, int start, int end) {
        this.charVector = Objects.requireNonNull(charVector);

        if (start >= 0 && start < charVector.size()) {
            this.start = start;
        } else throw new IllegalArgumentException("Inicio fuera del rango permitido");

        if (end >= start && end <= charVector.size()) {
            this.end = end;
        } else throw new IllegalArgumentException("Final fuera del rango permitido");

        this.length = end - start;
    }

    public TextState(ReadOnlyCharVector charVector) {
        this(charVector, 0, charVector.size());
    }

    public TextState(char[] chars, int start, int end) {
        this(new ReadOnlyCharArray(Objects.requireNonNull(chars)), start, end);
    }

    public TextState(char[] chars) {
        this(new ReadOnlyCharArray(Objects.requireNonNull(chars)));
    }

    public TextState(String string, int start, int end) {
        this(new CharSequenceVector(string), start, end);
    }

    public TextState(String string) {
        this(new CharSequenceVector(string));
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int index) {
        index = start + index;
        if (index >= start && index < end) return charVector.valueOf(index);
        else throw new IndexOutOfBoundsException();
    }

    @Override
    public TextState subSequence(int start, int end) {
        return new TextState(charVector, start, end);
    }

    @Override
    public void printIn(PrintStream out) {
        forEach(out::print);
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();

        for (int i = start; i < end; i++) builder.append(charVector.valueOf(i));

        return builder.toString();
    }

    @Override
    public CharIterator iterator() {
        return new IndexedCharIterator(length, this::charAt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var textState = (TextState) o;
        return start == textState.start && end == textState.end && length == textState.length && Objects.equals(charVector, textState.charVector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charVector, start, end, length);
    }

}
