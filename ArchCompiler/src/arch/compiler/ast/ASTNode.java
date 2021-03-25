package arch.compiler.ast;

import arch.compiler.ambit.Ambit;
import arch.compiler.report.Report;

import java.io.PrintStream;
import java.util.List;

public interface ASTNode {

    boolean analyzeSemantic(Ambit ambit, List<Report> reports);

    void printLexemes(PrintStream out);

    void printSyntax(int level, PrintStream out);

    default void writeObjectCode(PrintStream out) {
        throw new UnsupportedOperationException("writeObjectCode no soportado para " + getClass().getSimpleName());
    }

}
