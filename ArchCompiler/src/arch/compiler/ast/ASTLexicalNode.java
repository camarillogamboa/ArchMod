package arch.compiler.ast;

import arch.compiler.ambit.Ambit;
import arch.compiler.grammar.Rule;
import arch.compiler.info.InfoStation;
import arch.compiler.lexical.Token;
import arch.compiler.report.Report;

import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

public class ASTLexicalNode extends ASTIdentityNode implements Comparable<ASTLexicalNode> {

    private final Token token;

    public ASTLexicalNode(Rule rule, Token token) {
        super(rule);
        this.token = Objects.requireNonNull(token);
    }

    public final Token getToken() {
        return token;
    }

    @Override
    public final boolean analyzeSemantic(Ambit ambit, List<Report> reports) {
        return true;
    }

    @Override
    public final void printLexemes(PrintStream out) {
        out.println(InfoStation.generateInfoString(this));
    }

    @Override
    public final void printSyntax(int level, PrintStream out) {
        out.println(" ".repeat(level) + InfoStation.generateInfoString(this));
    }

    @Override
    public final int compareTo(ASTLexicalNode o) {
        return token.compareTo(o.token);
    }

    @Override
    public final String toString() {
        return token.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ASTLexicalNode) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
