package arch.tools.property;

public final class Properties {

    private Properties() {
    }

    public static ReadOnlyByteProperty readOnlyProperty(byte b) {
        return new ReadOnlyByteProperty(b);
    }

    public static ReadOnlyShortProperty readOnlyProperty(short s) {
        return new ReadOnlyShortProperty(s);
    }

    public static ReadOnlyIntProperty readOnlyProperty(int i) {
        return new ReadOnlyIntProperty(i);
    }

    public static ReadOnlyLongProperty readOnlyProperty(long l) {
        return new ReadOnlyLongProperty(l);
    }

    public static ReadOnlyFloatProperty readOnlyProperty(float f) {
        return new ReadOnlyFloatProperty(f);
    }

    public static ReadOnlyDoubleProperty readOnlyProperty(double d) {
        return new ReadOnlyDoubleProperty(d);
    }

    public static ReadOnlyCharProperty readOnlyProperty(char c) {
        return new ReadOnlyCharProperty(c);
    }

    public static ReadOnlyBooleanProperty readOnlyProperty(boolean b) {
        return new ReadOnlyBooleanProperty(b);
    }

    public static <T> ReadOnlyReferenceProperty<T> readOnlyProperty(T t) {
        return new ReadOnlyReferenceProperty<>(t);
    }

    public static ByteProperty property(byte b) {
        return new ByteProperty(b);
    }

    public static ShortProperty property(short s) {
        return new ShortProperty(s);
    }

    public static IntProperty property(int i) {
        return new IntProperty(i);
    }

    public static LongProperty property(long l) {
        return new LongProperty(l);
    }

    public static FloatProperty property(float f) {
        return new FloatProperty(f);
    }

    public static DoubleProperty property(double d) {
        return new DoubleProperty(d);
    }

    public static CharProperty property(char c) {
        return new CharProperty(c);
    }

    public static BooleanProperty property(boolean b) {
        return new BooleanProperty(b);
    }

    public static <T> ReferenceProperty<T> property(T t) {
        return new ReferenceProperty<>(t);
    }

    public static ObservableByteProperty observableProperty(byte b) {
        return new ObservableByteProperty(b);
    }

    public static ObservableShortProperty observableProperty(short s) {
        return new ObservableShortProperty(s);
    }

    public static ObservableIntProperty observableProperty(int i) {
        return new ObservableIntProperty(i);
    }

    public static ObservableLongProperty observableProperty(long l) {
        return new ObservableLongProperty(l);
    }

    public static ObservableFloatProperty observableProperty(float f) {
        return new ObservableFloatProperty(f);
    }

    public static ObservableDoubleProperty observableProperty(double d) {
        return new ObservableDoubleProperty(d);
    }

    public static ObservableCharProperty observableProperty(char c) {
        return new ObservableCharProperty(c);
    }

    public static ObservableBooleanProperty observableProperty(boolean b) {
        return new ObservableBooleanProperty(b);
    }

    public static <T> ObservableReferenceProperty<T> observableProperty(T t) {
        return new ObservableReferenceProperty<>(t);
    }
}
