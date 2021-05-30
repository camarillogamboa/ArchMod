package arch.tools.io.textfile;


import arch.tools.collection.collector.CharCollector;

import java.io.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static arch.tools.object.ObjectUtil.theyAreNotNull;

public final class TextFileDAO {

    private TextFileDAO() {
    }

    public static boolean create(File file, TextState textState) {
        if (!theyAreNotNull(file, textState)) return false;

        if (file.exists()) return update(file, textState);
        else try {
            return file.createNewFile() && update(file, textState);
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public static TextState load(File file) {
        if (!theyAreNotNull(file)) return null;
        var collector = new CharCollector();
        if (readOf(file, in -> {
            try {
                collector.put((char) in.read());
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        })) return new TextState(collector.asArray());

        return null;
    }

    public static boolean update(File file, TextState textState) {
        if (!theyAreNotNull(file, textState)) return false;

        if (!file.exists()) return create(file, textState);
        else return writeIn(file, textState::printIn);
    }

    public static boolean delete(File file) {
        return theyAreNotNull(file) && file.exists() && file.delete();
    }

    public static boolean copy(File original, File copy) {
        return theyAreNotNull(original, copy) && original.exists() && create(copy, load(original));
    }

    public static boolean move(File before, File after) {
        return theyAreNotNull(before, after) && before.exists() && create(after, load(before)) && delete(before);
    }

    public static InputStream in(File file) throws IOException {
        return new FileInputStream(file);
    }

    public static PrintStream out(File file) throws IOException {
        return new PrintStream(new FileOutputStream(file));
    }

    public static Stream<String> streamOf(File file) {
        try {
            return new BufferedReader(new FileReader(file)).lines();
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static boolean writeIn(File file, Consumer<PrintStream> action) {
        boolean flag;
        try (var out = out(file)) {
            action.accept(out);
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            flag = false;
        }
        return flag;
    }

    public static boolean readOf(File file, Consumer<InputStream> action) {
        boolean flag;
        try (var in = in(file)) {
            action.accept(in);
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            flag = false;
        }
        return flag;
    }

}
