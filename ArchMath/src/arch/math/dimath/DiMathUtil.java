package arch.math.dimath;

import arch.math.operator.DoubleArithmetic;
import arch.math.operator.Function;
import arch.tools.collection.array.ReadOnlyReferenceVector;
import arch.tools.collection.array.ReferenceArrayFiller;
import arch.tools.collection.node.ComparableEntryNodeBase;
import arch.tools.collection.table.IndexedTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

public interface DiMathUtil {

    Map<String, DoubleUnaryOperator> FUNCTIONS = new HashMap<>() {
        {
            put("sin", Function.SIN);
            put("cos", Function.COS);
            put("tan", Function.TAN);
            put("asin", Function.ASIN);
            put("acos", Function.ACOS);
            put("atan", Function.ATAN);
            put("csc", Function.CSC);
            put("sec", Function.SEC);
            put("cot", Function.COT);
            put("sinh", Function.SINH);
            put("cosh", Function.COSH);
            put("tanh", Function.TANH);
            put("csch", Function.CSCH);
            put("sech", Function.SECH);
            put("coth", Function.COTH);
            put("asinh", Function.ASINH);
            put("acosh", Function.ACOSH);
            put("atanh", Function.ATANH);
            put("acoth", Function.ACOTH);
            put("asech", Function.ASECH);
            put("acsch", Function.ACSCH);
            put("log", Function.LOG);
            put("log10", Function.LOG_10);
            put("exp", Function.EXP);
            put("sqrt", Function.SQRT);
            put("cbrt", Function.CBRT);
            put("abs", Function.ABS);
            put("neg", Function.NEG);
            put("rad", Function.TO_RADIANS);
            put("deg", Function.TO_DEGREES);
            put("inv", Function.INV);
        }

        @Override
        public DoubleUnaryOperator get(Object key) {
            var value = super.get(key);
            if (value != null) return value;
            else throw new IllegalArgumentException("Nombre de función no reconocida: \"" + key.toString() + "\"");
        }
    };

    static DoubleSupplier parseLiteral(String literal) throws NumberFormatException {
        return parseDouble(Double.parseDouble(literal));
    }

    static DoubleSupplier parseDouble(double constant) {
        return () -> constant;
    }

    static DoubleSupplier parseOperatorAndJoin(String symbol, DoubleSupplier a, DoubleSupplier b) throws IllegalArgumentException {
        return joinOperating(parseOperator(symbol), a, b);
    }

    static DoubleSupplier joinOperating(DoubleBinaryOperator o, DoubleSupplier a, DoubleSupplier b) {
        return () -> o.applyAsDouble(a.getAsDouble(), b.getAsDouble());
    }

    static DoubleBinaryOperator parseOperator(String symbol) throws IllegalArgumentException {
        return switch (symbol) {
            case "+" -> DoubleArithmetic.SUM;
            case "-" -> DoubleArithmetic.SUB;
            case "*" -> DoubleArithmetic.MUL;
            case "/" -> DoubleArithmetic.DIV;
            case "%" -> DoubleArithmetic.PER;
            case "^" -> DoubleArithmetic.POW;
            default -> throw new IllegalArgumentException("Símbolo de operador no reconocido: \"" + symbol + "\"");
        };
    }

    static DoubleSupplier parseFunctionAndJoin(String symbol, DoubleSupplier a) throws IllegalStateException {
        return joinFunctionAndValuable(parseFunction(symbol), a);
    }

    static DoubleSupplier joinFunctionAndValuable(DoubleUnaryOperator u, DoubleSupplier a) {
        return () -> u.applyAsDouble(a.getAsDouble());
    }

    static DoubleUnaryOperator parseFunction(String symbol) throws IllegalArgumentException {
        return FUNCTIONS.get(symbol);
    }

    static IndexedTable<String, Variable> toIndexedTable(List<Lexeme> vars) {
        ComparableEntryNodeBase<String, Variable>[] array = new ComparableEntryNodeBase[vars.size()];

        var filler = new ReferenceArrayFiller<>(array);

        vars.forEach(lex -> filler.put(new ComparableEntryNodeBase<>(lex.toString(), new Variable())));

        return new IndexedTable<>(array);
    }

    static IndexedTable<String, DoubleSupplier> toIndexedTable(Map<Lexeme, Lexeme> factors, ReadOnlyReferenceVector<DoubleSupplier> externals) throws DiMathException {
        ComparableEntryNodeBase<String, DoubleSupplier>[] array = new ComparableEntryNodeBase[factors.size()];

        var filler = new ReferenceArrayFiller<>(array);

        DoubleSupplier ds;

        for (var entry : factors.entrySet()) {
            if (!entry.getKey().isDeclarer())
                throw new DiMathException("Los pares deben de tener como clave un Declarador.");
            switch (entry.getValue().getKind()) {
                case INT_LIT, FLOAT_LIT -> ds = parseLiteral(entry.getValue().toString());
                case INDEX_REFERENCE -> ds = externals.valueOf(Integer.parseInt(entry.getValue().toString()));
                default -> throw new DiMathException("Elemento de bloque de factores inválido");
            }
            filler.put(new ComparableEntryNodeBase<>(entry.getKey().toString(), ds));
        }

        return new IndexedTable<>(array);
    }

    static PostfixExpression[] mapEachToPostfixExpression(InfixExpression[] infixExpressions) throws DiMathException {
        var postfixExpressions = new PostfixExpression[infixExpressions.length];
        for (int i = 0; i < postfixExpressions.length; i++)
            postfixExpressions[i] = infixExpressions[i].toPostfixExpression();
        return postfixExpressions;
    }

}
