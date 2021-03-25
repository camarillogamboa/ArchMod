package arch.compiler.syntax;

import arch.compiler.ast.ASTNode;
import arch.compiler.lexical.Token;
import arch.tools.collection.iterator.Pointer;

@FunctionalInterface
public interface SyntaxNode {

    ASTNode parse(Pointer<Token> tokenPointer) throws ParseException;

}
