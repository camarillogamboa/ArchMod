package arch.tools.collection;

@FunctionalInterface
public interface Sizable {

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

}
