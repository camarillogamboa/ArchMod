package arch.compiler.ast.annotation;

import arch.compiler.ast.ASTNode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Alternation {

    Class<? extends ASTNode>[] alternatives();

}
