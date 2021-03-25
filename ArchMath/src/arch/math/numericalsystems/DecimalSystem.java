package arch.math.numericalsystems;

public final class DecimalSystem implements NumericSystem<DecimalLiteral> {

    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    @Override
    public int base() {
        return 10;
    }

    @Override
    public char[] digits() {
        return DIGITS;
    }

    @Override
    public boolean isASystemLiteral(String literal) {
        return false;
    }

    @Override
    public DecimalLiteral sum(DecimalLiteral a, DecimalLiteral b) {
        return null;
    }

    @Override
    public DecimalLiteral sub(DecimalLiteral a, DecimalLiteral b) {
        return null;
    }

    @Override
    public DecimalLiteral mul(DecimalLiteral a, DecimalLiteral b) {
        return null;
    }

    @Override
    public DecimalLiteral div(DecimalLiteral a, DecimalLiteral b) {
        return null;
    }
}
