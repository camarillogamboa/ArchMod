package arch.tools.util;

import java.util.Iterator;
import java.util.Objects;

public final class ObjectUtil {

    private ObjectUtil() {
    }

    public static boolean basicEquals(Object a, Object b) {
        if (a == b) return true;

        return a != null && b != null && a.getClass() == b.getClass();
    }

    public static void requireNonNull(Object... objects) {
        Objects.requireNonNull(objects);
        for (var o : objects) Objects.requireNonNull(o);
    }

    public static boolean theyAreNotNull(Object... objects) {
        try {
            requireNonNull(objects);
            return true;
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public static <E> int hashCode(Iterator<E> iterator) {
        if (iterator == null) return 0;

        int result = 1;

        while (iterator.hasNext()) {
            var element = iterator.next();
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }
        return result;
    }
}
