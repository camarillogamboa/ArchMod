package arch.math.dimath;

import java.util.function.DoubleSupplier;

public final class Variable implements DoubleSupplier {

    private double value;

    public Variable(double value) {
        this.value = value;
    }

    public Variable() {
        this(0);
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getAsDouble() {
        return value;
    }

}
