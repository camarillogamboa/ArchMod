package arch.compiler.ebnf;

import arch.compiler.ambit.Ambit;
import arch.compiler.ast.ASTNode;
import arch.compiler.ast.ASTSyntaxNode;
import arch.compiler.grammar.Rule;
import arch.compiler.report.Report;

import java.util.List;
import java.util.Objects;

public final class EBNFProduction extends ASTSyntaxNode {

    private final EBNFIdentifier ebnfIdentifier;
    private final EBNFSymbol.EBNFDefinition ebnfDefinition;
    private final EBNFProductionBody ebnfProductionBody;

    public EBNFProduction(Rule rule, EBNFIdentifier ebnfIdentifier, EBNFSymbol.EBNFDefinition ebnfDefinition, EBNFProductionBody ebnfProductionBody) {
        super(rule);
        this.ebnfIdentifier = Objects.requireNonNull(ebnfIdentifier);
        this.ebnfDefinition = Objects.requireNonNull(ebnfDefinition);
        this.ebnfProductionBody = Objects.requireNonNull(ebnfProductionBody);
    }

    @Override
    public boolean analyzeSemantic(Ambit ambit, List<Report> reports) {
        return false;
    }

    @Override
    public ASTNode[] getChildren() {
        return new ASTNode[]{ebnfIdentifier, ebnfDefinition, ebnfProductionBody};
    }
}
