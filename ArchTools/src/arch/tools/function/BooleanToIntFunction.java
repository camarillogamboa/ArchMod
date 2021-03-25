package arch.tools.function;

@FunctionalInterface
public interface BooleanToIntFunction {

    BooleanToIntFunction TO_INT = b -> b ? 1 : 0;

    int applyAsInt(boolean b);

}
