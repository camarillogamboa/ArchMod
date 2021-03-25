package arch.compiler.info;

import arch.compiler.ast.ASTLexicalNode;
import arch.compiler.ast.ASTSyntaxNode;

public interface InfoGenerator {

    String generateInfoString(ASTLexicalNode astLexicalNode);

    String generateInfoString(ASTSyntaxNode astSyntaxNode);

    String[] getBlockSymbols();

}
