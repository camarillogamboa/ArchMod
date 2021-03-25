package arch.tools.function;

@FunctionalInterface
public interface BooleanToIntBiFunction {

    int applyAsInt(boolean a, boolean b);

}
