package arch.math.dimath;

import java.util.Objects;

public final class Lexeme implements Comparable<Lexeme> {

    private final AbstractKind kind;
    private final String symbol;

    private final Type type;

    private final int precedence;

    public Lexeme(AbstractKind kind, String symbol) {
        this.kind = Objects.requireNonNull(kind);
        this.symbol = Objects.requireNonNull(symbol);
        switch (kind) {
            case OPERATOR -> {
                precedence = switch (symbol) {
                    case "+", "-" -> 3;
                    case "*", "/", "%" -> 4;
                    case "^" -> 5;
                    case "<" -> 6;
                    default -> throw new IllegalArgumentException("Símbolo de operador no reconocido: \"" + symbol + "\"");
                };
                type = Type.OPERATOR;
            }
            case PARAMETER_FACTOR_REFERENCE, FUNCTION_REFERENCE, INDEX_REFERENCE, INT_LIT, FLOAT_LIT -> {
                precedence = 0;
                type = Type.OPERATING;
            }
            case LEFT_GROUPER, RIGHT_GROUPER -> {
                precedence = switch (symbol) {
                    case "(" -> 1;
                    case ")" -> 2;
                    default -> throw new IllegalArgumentException("Símbolo de agrupador no reconocido: \"" + symbol + "\"");
                };
                type = Type.GROUPER;
            }
            case PARAMETER_NAME, FACTOR_NAME -> {
                precedence = 0;
                type = Type.DECLARER;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public AbstractKind getKind() {
        return kind;
    }

    public Type getType() {
        return type;
    }

    public int getPrecedence() {
        return precedence;
    }

    public boolean isOperator() {
        return type == Type.OPERATOR;
    }

    public boolean isOperating() {
        return type == Type.OPERATING;
    }

    public boolean isGrouper() {
        return type == Type.GROUPER;
    }

    public boolean isDeclarer() {
        return type == Type.DECLARER;
    }

    @Override
    public int compareTo(Lexeme o) {
        Objects.requireNonNull(o);
        return symbol.compareTo(o.symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var lexeme = (Lexeme) o;
        return kind == lexeme.kind && Objects.equals(symbol, lexeme.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }

    public enum AbstractKind {
        OPERATOR, PARAMETER_FACTOR_REFERENCE, FUNCTION_REFERENCE, INDEX_REFERENCE, INT_LIT, FLOAT_LIT, LEFT_GROUPER, RIGHT_GROUPER, PARAMETER_NAME, FACTOR_NAME
    }

    public enum Type {
        OPERATING, GROUPER, OPERATOR, DECLARER
    }

}
