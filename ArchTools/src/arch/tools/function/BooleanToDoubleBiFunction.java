package arch.tools.function;

@FunctionalInterface
public interface BooleanToDoubleBiFunction {

    double applyAsDouble(boolean a, boolean b);

}
