package arch.tools.desingpattern.sent;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MultiReceiverTransmitter<T> extends TransmitterBase<T> {

    private final List<Receiver<T>> receivers;

    public MultiReceiverTransmitter(List<Receiver<T>> receivers) {
        super(receivers);
        this.receivers = Objects.requireNonNull(receivers);
    }

    @SafeVarargs
    public MultiReceiverTransmitter(Receiver<T>... receivers) {
        this(Arrays.asList(receivers));
    }

    public MultiReceiverTransmitter() {
        this(new LinkedList<>());
    }

    public List<Receiver<T>> getReceivers() {
        return receivers;
    }
}
