package arch.math.dimath;

import java.util.Arrays;

public record OrderedPair(double[] domainKey, double[] image) {

    @Override
    public String toString() {
        return "OrderedPair{" + "domainKey = " + Arrays.toString(domainKey) + ", image = " + Arrays.toString(image) + '}';
    }

}
