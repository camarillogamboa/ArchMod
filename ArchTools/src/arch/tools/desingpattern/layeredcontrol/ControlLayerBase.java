package arch.tools.desingpattern.layeredcontrol;

import arch.tools.property.ObservableReferenceProperty;
import arch.tools.property.Properties;
import arch.tools.property.ReferenceProperty;
import arch.tools.util.RunnableAssistant;

import java.util.Objects;

public abstract class ControlLayerBase implements ControlLayer {

    private final ReferenceProperty<Runnable> closingActionProperty;
    protected final ObservableReferenceProperty<ControlLayer> topLayerProperty;

    public ControlLayerBase(Runnable closingAction, ControlLayer topLayer) {
        this.closingActionProperty = Properties.property(Objects.requireNonNull(closingAction));
        this.topLayerProperty = Properties.observableProperty(topLayer);
    }

    public ControlLayerBase(Runnable closeAction) {
        this(closeAction, ControlLayer.DEFAULT_CONTROL_LAYER);
    }

    @Override
    public final ClosingOrder generateCloseOrder() {
        var closingOrderTopLayer = topLayerProperty.get().generateCloseOrder();

        return new ClosingOrder(() -> {
            closingOrderTopLayer.run();
            closingActionProperty.consume(Runnable::run);
        }, closingOrderTopLayer.isAllowed() && confirmClosure());
    }

    protected abstract boolean confirmClosure();

    public final void setBeforeClosingAction(Runnable runnable) {
        closingActionProperty.map(r -> RunnableAssistant.link(runnable, r));
    }

    public final void setAfterClosingAction(Runnable runnable) {
        closingActionProperty.map(r -> RunnableAssistant.link(r, runnable));
    }
}
