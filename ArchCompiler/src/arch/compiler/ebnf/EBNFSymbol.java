package arch.compiler.ebnf;

import arch.compiler.ast.ASTLexicalNode;
import arch.compiler.grammar.Rule;
import arch.compiler.lexical.Token;

public class EBNFSymbol extends ASTLexicalNode {

    private EBNFSymbol(Rule rule, Token token) {
        super(rule, token);
    }

    public static final class EBNFDefinition extends EBNFSymbol {

        public EBNFDefinition(Rule rule) {
            super(rule, new Token(0, ":="));
        }

    }

    public static final class EBNFLeftBrace extends EBNFSymbol {

        public EBNFLeftBrace(Rule rule, Token token) {
            super(rule, token);
        }
    }

    public static final class EBNFLeftBracket extends EBNFSymbol {

        public EBNFLeftBracket(Rule rule, Token token) {
            super(rule, token);
        }
    }

    public static final class EBNFLeftParenthesis extends EBNFSymbol {

        public EBNFLeftParenthesis(Rule rule, Token token) {
            super(rule, token);
        }
    }

    public static final class EBNFRightBrace extends EBNFSymbol {

        public EBNFRightBrace(Rule rule, Token token) {
            super(rule, token);
        }
    }

    public static final class EBNFRightBracket extends EBNFSymbol {

        private EBNFRightBracket(Rule rule, Token token) {
            super(rule, token);
        }
    }

    public static final class EBNFRightParenthesis extends EBNFSymbol {

        private EBNFRightParenthesis(Rule rule, Token token) {
            super(rule, token);
        }
    }

}
