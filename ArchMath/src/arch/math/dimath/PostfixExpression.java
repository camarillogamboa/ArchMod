package arch.math.dimath;

import arch.tools.collection.LinkedStack;

import java.util.LinkedList;
import java.util.List;

public final class PostfixExpression extends Expression {

    PostfixExpression(InfixExpression infixExpression) throws DiMathException {
        super(toPostfix(infixExpression.lexemes));
    }

    private static List<Lexeme> toPostfix(List<Lexeme> infix) throws DiMathException {
        var stack = new LinkedStack<Lexeme>();
        var postfix = new LinkedList<Lexeme>();

        stack.push(new Lexeme(Lexeme.AbstractKind.LEFT_GROUPER, "("));
        infix.add(new Lexeme(Lexeme.AbstractKind.RIGHT_GROUPER, ")"));

        try {
            for (var lex : infix)
                switch (lex.getType()) {
                    case OPERATING -> postfix.add(lex);
                    case GROUPER -> {
                        switch (lex.getKind()) {
                            case LEFT_GROUPER -> stack.push(lex);
                            case RIGHT_GROUPER -> {
                                while (!stack.peek().toString().equals("(")) postfix.add(stack.pop());
                                stack.pop();
                            }
                            default -> throw new IllegalArgumentException("Valor inesperado: " + lex.toString());
                        }
                    }
                    case OPERATOR -> {
                        while (stack.peek().isOperator() && stack.peek().getPrecedence() >= lex.getPrecedence())
                            postfix.add(stack.pop());

                        stack.push(lex);
                    }
                    default -> throw new IllegalArgumentException("Tipo de lexema no admitido");
                }
        } catch (IllegalArgumentException e) {
            throw new DiMathException(e);
        }

        return postfix;
    }

}
