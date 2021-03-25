package arch.tools.desingpattern.sent;

import java.util.Objects;

public class TransmitterBase<T> implements Transmitter<T> {

    private final Receiver<T> receiver;

    public TransmitterBase(Receiver<T> receiver) {
        this.receiver = Objects.requireNonNull(receiver);
    }

    public TransmitterBase(Iterable<? extends Receiver<T>> receivers) {
        this(t -> receivers.forEach(r -> r.receive(t)));
    }

    @Override
    public void emit(T data) {
        receiver.receive(data);
    }

}
