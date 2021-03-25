package arch.compiler.ebnf;

import arch.compiler.ambit.Ambit;
import arch.compiler.ast.ASTNode;
import arch.compiler.ast.ASTSyntaxNode;
import arch.compiler.ast.annotation.Alternation;
import arch.compiler.grammar.Rule;
import arch.compiler.report.Report;

import java.util.List;
import java.util.Objects;

public final class EBNFProductionBody extends ASTSyntaxNode {

    private final EBNFAlternative ebnfAlternative;

    public EBNFProductionBody(Rule rule, EBNFAlternative ebnfAlternative) {
        super(rule);
        this.ebnfAlternative = Objects.requireNonNull(ebnfAlternative);
    }

    public EBNFAlternative getEBNFAlternative() {
        return ebnfAlternative;
    }

    @Override
    public boolean analyzeSemantic(Ambit ambit, List<Report> reports) {
        return ebnfAlternative.analyzeSemantic(ambit, reports);
    }

    @Override
    public ASTNode[] getChildren() {
        return new ASTNode[]{ebnfAlternative};
    }

    @Alternation(alternatives = {

    })
    public interface EBNFAlternative extends ASTNode {

    }
}
