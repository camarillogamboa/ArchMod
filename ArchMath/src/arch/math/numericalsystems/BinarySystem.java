package arch.math.numericalsystems;

public final class BinarySystem implements NumericSystem<BinaryLiteral> {

    public static final char[] DIGITS = {'0', '1'};

    @Override
    public int base() {
        return 2;
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
    public BinaryLiteral sum(BinaryLiteral a, BinaryLiteral b) {
        return null;
    }

    @Override
    public BinaryLiteral sub(BinaryLiteral a, BinaryLiteral b) {
        return null;
    }

    @Override
    public BinaryLiteral mul(BinaryLiteral a, BinaryLiteral b) {
        return null;
    }

    @Override
    public BinaryLiteral div(BinaryLiteral a, BinaryLiteral b) {
        return null;
    }
}
