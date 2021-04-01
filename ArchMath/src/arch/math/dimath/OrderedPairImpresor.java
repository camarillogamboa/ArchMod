package arch.math.dimath;


import arch.tools.collection.array.Arrays;
import arch.tools.collection.array.ReadOnlyReferenceVector;

import java.io.PrintStream;
import java.util.Objects;
import java.util.function.Consumer;

public final class OrderedPairImpresor implements Consumer<OrderedPair> {

    private final PrintStream out;
    private final ReadOnlyReferenceVector<String> tags;

    public OrderedPairImpresor(PrintStream out, ReadOnlyReferenceVector<String> tags) {
        this.out = Objects.requireNonNull(out);
        this.tags = tags;
    }

    public OrderedPairImpresor(PrintStream out, String tags) {
        this(out, Arrays.readOnlyArrayOf(tags));
    }

    @Override
    public void accept(OrderedPair orderedPair) {

        double[] temp = orderedPair.domainKey();

        int iMax = temp.length - 1;

        if (iMax == -1) out.print("()");
        else {
            out.print("(");
            for (int i = 0; ; i++) {
                out.print(tags.valueOf(i) + ": " + temp[i]);
                if (i == iMax) {
                    out.print(") -> {");
                    break;
                }
                out.print(", ");
            }
        }

        temp = orderedPair.image();
        iMax = temp.length - 1;

        for (int i = 0; ; i++) {
            out.print(temp[i]);
            if (i == iMax) {
                out.println("}");
                break;
            }
            out.print(", ");
        }

    }
}
