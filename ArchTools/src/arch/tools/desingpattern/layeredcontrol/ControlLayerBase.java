package arch.tools.desingpattern.layeredcontrol;

import arch.tools.ExtendedRunnable;
import arch.tools.property.ObservableReferenceProperty;
import arch.tools.property.Properties;

public abstract class ControlLayerBase implements ControlLayer {

    private ExtendedRunnable closingAction;
    protected final ObservableReferenceProperty<ControlLayer> topLayerProperty;

    public ControlLayerBase(Runnable closingAction, ControlLayer topLayer) {
        this.closingAction = ExtendedRunnable.update(closingAction);
        this.topLayerProperty = Properties.observableProperty(topLayer);
    }

    public ControlLayerBase(Runnable closingAction) {
        this(closingAction, ControlLayer.DEFAULT_CONTROL_LAYER);
    }

    @Override
    public final ClosingOrder generateCloseOrder() {
        var closingOrderTopLayer = topLayerProperty.get().generateCloseOrder();

        var allowed = closingOrderTopLayer.isAllowed() && confirmClosure();

        return new ClosingOrder(closingOrderTopLayer.andThen(closingAction), allowed);
    }

    protected abstract boolean confirmClosure();

    public final void setBeforeClosingAction(Runnable beforeClosingAction) {
        closingAction = ExtendedRunnable.update(beforeClosingAction).andThen(closingAction);
    }

    public final void setAfterClosingAction(Runnable afterClosingAction) {
        closingAction = closingAction.andThen(afterClosingAction);
    }

}
