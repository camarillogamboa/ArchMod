package arch.tools.function;

@FunctionalInterface
public interface BooleanBinaryOperator {

    BooleanBinaryOperator OR = (a, b) -> a || b;
    BooleanBinaryOperator AND = (a, b) -> a && b;
    BooleanBinaryOperator NOR = (a, b) -> BooleanUnaryOperator.NOT.applyAsBoolean(OR.applyAsBoolean(a, b));
    BooleanBinaryOperator NAND = (a, b) -> BooleanUnaryOperator.NOT.applyAsBoolean(AND.applyAsBoolean(a, b));
    BooleanBinaryOperator XOR = (a, b) -> AND.applyAsBoolean(NAND.applyAsBoolean(a, b), OR.applyAsBoolean(a, b));
    BooleanBinaryOperator XNOR = (a, b) -> BooleanUnaryOperator.NOT.applyAsBoolean(XOR.applyAsBoolean(a, b));

    boolean applyAsBoolean(boolean a, boolean b);

}
