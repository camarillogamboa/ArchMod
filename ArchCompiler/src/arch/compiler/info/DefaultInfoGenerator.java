package arch.compiler.info;

import arch.compiler.ast.ASTLexicalNode;
import arch.compiler.ast.ASTSyntaxNode;

public final class DefaultInfoGenerator implements InfoGenerator {

    public static final String[] BLOCK_SYMBOLS = {"{", "}"};

    @Override
    public String generateInfoString(ASTLexicalNode astLexicalNode) {
        var tk = astLexicalNode.getToken();
        var lexP = "<[" + tk.getBeginLine() + ":" + tk.getBeginColumn() + "]-[" + tk.getEndLine() + ":" + tk.getEndColumn() + "]>";
        return lexP + " " + tk.toString();
    }

    @Override
    public String generateInfoString(ASTSyntaxNode astSyntaxNode) {
        return astSyntaxNode.getRule().getName();
    }

    @Override
    public String[] getBlockSymbols() {
        return BLOCK_SYMBOLS;
    }
}
