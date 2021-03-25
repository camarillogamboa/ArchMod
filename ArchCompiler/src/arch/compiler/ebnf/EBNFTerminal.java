package arch.compiler.ebnf;

import arch.compiler.ast.ASTLexicalNode;
import arch.compiler.grammar.Rule;
import arch.compiler.lexical.Token;

public class EBNFTerminal extends ASTLexicalNode implements EBNFProductionBody.EBNFAlternative {

    public EBNFTerminal(Rule rule, Token token) {
        super(rule, token);
    }
}
