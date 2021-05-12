package arch.tools.desingpattern.observer;

import arch.tools.desingpattern.observer.event.Event;

public interface Observable<E extends Event> {

    void addObserver(Observer<E> observer);

    void removeObserver(Observer<E> observer);

}
