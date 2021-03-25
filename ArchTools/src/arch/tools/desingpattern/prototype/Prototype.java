package arch.tools.desingpattern.prototype;

@FunctionalInterface
public interface Prototype<T> {

    T cloneThis();
}
