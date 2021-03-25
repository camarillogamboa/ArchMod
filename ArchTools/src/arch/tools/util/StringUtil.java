package arch.tools.util;

import arch.tools.collection.iterator.Iterators;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class StringUtil {

    private StringUtil() {
    }

    public static String basicNumberFormat(int integer) {
        String en = String.valueOf(integer);
        return "0".repeat(Math.abs(4 - en.length())) + en;
    }

    public static String commaSeparator(String... values) {
        return symbolSeparator(",", values);
    }

    public static String symbolSeparator(String symbol, String... values) {
        var builder = new StringBuilder();
        for (int i = 0; i < values.length - 1; i++) builder.append(values[i]).append(symbol);
        builder.append(values[values.length - 1]);
        return builder.toString();
    }

    public static String[] symbolDivider(String value, String symbol) {
        return value.split(symbol);
    }

    public static <E> String[] toString(E[] array, Function<E, String> function) {
        var strings = new String[array.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = function.apply(array[i]);
        }
        return strings;
    }

    public static String iterableToString(Iterable<String> iterable) {
        StringBuilder builder = new StringBuilder();

        iterable.forEach(s -> {
            builder.append(s);
            builder.append(System.lineSeparator());
        });
        return builder.toString();
    }

    public static InputStream toInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }

    public static String camelCaseToSnakeCase(String camelCase, boolean isConstant) {
        var builder = new StringBuilder();

        Iterators.iterate(camelCase, c -> {
            if (Character.isUpperCase(c) && !builder.isEmpty()) builder.append("_");
            builder.append(isConstant ? Character.toUpperCase(c) : c);
        });

        return builder.toString();
    }

    public static String snakeCaseToCamelCase(String snakeCase) {
        var builder = new StringBuilder();
        var previewChar = new AtomicReference<>('_');

        Iterators.iterate(snakeCase, c -> {
            if (previewChar.get() == '_' && c != '_') builder.append(Character.toUpperCase(c));
            else if (c != '_') builder.append(Character.toLowerCase(c));
            previewChar.set(c);
        });

        return builder.toString();
    }


}
