package arch.math.dimath;


import java.io.PrintStream;
import java.util.Objects;
import java.util.function.Consumer;

public final class OrderedPairImpresor implements Consumer<OrderedPair> {

    private final PrintStream out;
    private final String[] tags;

    public OrderedPairImpresor(PrintStream out, String... tags) {
        this.out = Objects.requireNonNull(out);
        this.tags = tags;
    }

    @Override
    public void accept(OrderedPair orderedPair) {
        out.print("(");

        var domainKey = orderedPair.domainKey();

        for (int i = 0; i < domainKey.length - 1; i++) out.print(tags[i] + ": " + domainKey[i] + ", ");

        if (domainKey.length > 0) out.print(tags[domainKey.length - 1] + ": " + domainKey[domainKey.length - 1]);

        out.print(") → {");

        var image = orderedPair.image();
        for (int i = 0; i < image.length - 1; i++) out.print(image[i] + ", ");

        if (image.length > 0) out.print(image[image.length - 1]);

        out.println("}");
    }
}
