package arch.math.dimath;

import arch.math.dimath.parser.DiMathCompiler;

import java.util.List;

public final class InfixExpression extends Expression {

    public InfixExpression(List<Lexeme> lexemes) {
        super(lexemes);
    }

    public InfixExpression(String infixSource) throws DiMathException {
        this(DiMathCompiler.compileExpression(infixSource));
    }

    public PostfixExpression toPostfixExpression() throws DiMathException {
        return new PostfixExpression(this);
    }

}
