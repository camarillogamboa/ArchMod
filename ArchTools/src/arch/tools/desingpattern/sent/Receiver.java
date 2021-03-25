package arch.tools.desingpattern.sent;

import java.util.function.Consumer;

@FunctionalInterface
public interface Receiver<T> {

    void receive(T data);

    static <T> Receiver<T> toReceiver(Consumer<T> consumer) {
        return consumer::accept;
    }
}
