package arch.math.numericalsystems;

public interface NumericSystem<L extends NumericLiteral> {

    int base();

    char[] digits();

    boolean isASystemLiteral(String literal);

    default long placeValueOf(int position) {
        return (long) Math.pow(base(), position);
    }

    L sum(L a, L b);

    L sub(L a, L b);

    L mul(L a, L b);

    L div(L a, L b);
}
