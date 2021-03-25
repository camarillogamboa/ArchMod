package arch.tools.desingpattern.sent;

import java.util.Arrays;

@FunctionalInterface
public interface Transmitter<T> {

    void emit(T data);

    static <T> Transmitter<T> create(Receiver<T>... receivers) {
        return create(Arrays.asList(receivers));
    }

    static <T> Transmitter<T> create(Iterable<Receiver<T>> receivers) {
        return t -> receivers.forEach(r -> r.receive(t));
    }

}
