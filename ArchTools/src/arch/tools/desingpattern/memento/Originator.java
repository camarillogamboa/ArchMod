package arch.tools.desingpattern.memento;

public interface Originator {

    Memento save();

    void restore(Memento memento);
}
