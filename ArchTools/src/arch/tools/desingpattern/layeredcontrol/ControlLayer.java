package arch.tools.desingpattern.layeredcontrol;

import java.io.Closeable;

@FunctionalInterface
public interface ControlLayer extends Closeable {

    ControlLayer DEFAULT_CONTROL_LAYER = () -> ClosingOrder.DEFAULT_CLOSE_ORDER;

    ClosingOrder generateCloseOrder();

    @Override
    default void close() {
        generateCloseOrder().run();
    }
}
