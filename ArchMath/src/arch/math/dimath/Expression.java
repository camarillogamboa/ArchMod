package arch.math.dimath;

import arch.tools.collection.array.ReadOnlyReferenceVector;
import arch.tools.io.Printable;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Expression implements ReadOnlyReferenceVector<Lexeme>, Printable {

    protected final List<Lexeme> lexemes;

    Expression(List<Lexeme> lexemes) {
        this.lexemes = Objects.requireNonNull(lexemes);
    }

    @Override
    public final int size() {
        return lexemes.size();
    }

    @Override
    public final Lexeme valueOf(int index) {
        return lexemes.get(index);
    }

    @Override
    public final Iterator<Lexeme> iterator() {
        var iterator = lexemes.iterator();
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Lexeme next() {
                return iterator.next();
            }
        };
    }

    @Override
    public final void printIn(PrintStream out) {
        forEach(l -> out.print(l.toString() + " "));
        out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var expression = (Expression) o;
        return Objects.equals(lexemes, expression.lexemes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexemes);
    }

}
