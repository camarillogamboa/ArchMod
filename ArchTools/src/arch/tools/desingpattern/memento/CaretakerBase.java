package arch.tools.desingpattern.memento;

import java.util.Objects;
import java.util.Stack;

public class CaretakerBase implements Caretaker {

    protected final Originator originator;
    protected final Stack<Memento> history;

    public CaretakerBase(Originator originator) {
        this.originator = Objects.requireNonNull(originator);
        this.history = new Stack<>();
    }

    @Override
    public final void doSomething() {
        history.push(originator.save());
    }

    @Override
    public final void undo() {
        originator.restore(history.pop());
    }
}
