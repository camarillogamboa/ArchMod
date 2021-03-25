package arch.tools.function;

import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
public interface FunctionalFactory<E, A> {

    E create(A arg);

    default E create(A arg, Consumer<E> action) {
        return doWithTheObject(create(arg), action);
    }

    default E create(Consumer<E> action) {
        return create(null, action);
    }

    default E create() {
        return create((A) null);
    }

    default E doWithTheObject(E e, Consumer<E> action) {
        action.accept(e);
        return e;
    }

    static <E, A> FunctionalFactory<E, A> createFactory(Supplier<E> generator) {
        return a -> generator.get();
    }

}
