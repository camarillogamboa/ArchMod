package arch.compiler.lexical;

import java.util.Objects;

public final class Token implements Comparable<Token> {

    private final int kind;

    private final String image;

    private final int beginLine;
    private final int beginColumn;
    private final int endLine;
    private final int endColumn;

    public Token(int kind, String image, int beginLine, int beginColumn, int endLine, int endColumn) {
        this.kind = kind;
        this.image = Objects.requireNonNull(image);
        this.beginLine = beginLine;
        this.beginColumn = beginColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }

    public Token(int kind, String image) {
        this(kind, image, -1, -1, -1, -1);
    }

    public int getKind() {
        return kind;
    }

    public int getBeginLine() {
        return beginLine;
    }

    public int getBeginColumn() {
        return beginColumn;
    }

    public int getEndLine() {
        return endLine;
    }

    public int getEndColumn() {
        return endColumn;
    }

    @Override
    public String toString() {
        return image;
    }

    @Override
    public int compareTo(Token o) {
        return image.compareTo(o.image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var token = (Token) o;
        return kind == token.kind && beginLine == token.beginLine && beginColumn == token.beginColumn && endLine == token.endLine && endColumn == token.endColumn && Objects.equals(image, token.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, image, beginLine, beginColumn, endLine, endColumn);
    }


}
