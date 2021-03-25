package arch.compiler.ast;

import arch.compiler.grammar.Rule;

import java.util.Objects;

public abstract class ASTIdentityNode implements ASTNode {

    private final Rule rule;

    public ASTIdentityNode(Rule rule) {
        this.rule = Objects.requireNonNull(rule);
    }

    public final Rule getRule() {
        return rule;
    }

}
