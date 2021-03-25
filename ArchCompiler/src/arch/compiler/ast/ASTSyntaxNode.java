package arch.compiler.ast;

import arch.compiler.grammar.Rule;
import arch.compiler.info.InfoStation;

import java.io.PrintStream;

public abstract class ASTSyntaxNode extends ASTIdentityNode {

    public ASTSyntaxNode(Rule rule) {
        super(rule);
    }

    @Override
    public final void printLexemes(PrintStream out) {
        for (var astNode : getChildren()) if (astNode != null) astNode.printLexemes(out);
    }

    @Override
    public final void printSyntax(int level, PrintStream out) {
        var space = " ".repeat(level);
        var bS = InfoStation.getBlockSymbols();
        out.println(space + InfoStation.generateInfoString(this) + bS[0]);
        for (var astNode : getChildren()) if (astNode != null) astNode.printSyntax(level + 1, out);
        out.println(space + bS[1]);
    }

    public abstract ASTNode[] getChildren();

}
