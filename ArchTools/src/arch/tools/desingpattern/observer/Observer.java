package arch.tools.desingpattern.observer;

import arch.tools.desingpattern.observer.event.Event;

@FunctionalInterface
public interface Observer<E extends Event> {

    void update(E event);

}
