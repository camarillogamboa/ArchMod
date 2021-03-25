package arch.tools.desingpattern.memento;

public interface Caretaker {

    void doSomething();

    void undo();

    static Caretaker createACaretaker(Originator originator) {
        return new CaretakerBase(originator);
    }

}
