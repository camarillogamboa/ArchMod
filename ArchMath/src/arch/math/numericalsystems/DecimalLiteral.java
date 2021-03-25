package arch.math.numericalsystems;

public final class DecimalLiteral implements NumericLiteral {

    private final String literal;

    public DecimalLiteral(String literal) {
        this.literal = literal;
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    @Override
    public double decimalValue() {
        return 0;
    }
}
