package arch.math.dimath;

import arch.math.operator.DoubleArithmetic;
import arch.math.operator.Function;
import arch.tools.collection.ReferenceAccesMap;
import arch.tools.collection.array.ReadOnlyReferenceVector;
import arch.tools.collection.array.ReferenceArrayFiller;
import arch.tools.collection.node.ComparableEntryNodeBase;
import arch.tools.collection.table.IndexedTable;
import arch.tools.desingpattern.dao.DataAccesObject;
import arch.tools.object.NotCreationException;
import arch.tools.object.NotReadException;

import java.util.List;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

public interface DiMathUtil {

    DataAccesObject<String,DoubleUnaryOperator> FUNCTIONS = new ReferenceAccesMap<>(){{
        try {
            create("sin", Function.SIN);
            create("cos", Function.COS);
            create("tan", Function.TAN);
            create("asin", Function.ASIN);
            create("acos", Function.ACOS);
            create("atan", Function.ATAN);
            create("csc", Function.CSC);
            create("sec", Function.SEC);
            create("cot", Function.COT);
            create("sinh", Function.SINH);
            create("cosh", Function.COSH);
            create("tanh", Function.TANH);
            create("csch", Function.CSCH);
            create("sech", Function.SECH);
            create("coth", Function.COTH);
            create("asinh", Function.ASINH);
            create("acosh", Function.ACOSH);
            create("atanh", Function.ATANH);
            create("acoth", Function.ACOTH);
            create("asech", Function.ASECH);
            create("acsch", Function.ACSCH);
            create("log", Function.LOG);
            create("log10", Function.LOG_10);
            create("exp", Function.EXP);
            create("sqrt", Function.SQRT);
            create("cbrt", Function.CBRT);
            create("abs", Function.ABS);
            create("neg", Function.NEG);
            create("rad", Function.TO_RADIANS);
            create("deg", Function.TO_DEGREES);
            create("inv", Function.INV);
        } catch (NotCreationException ignored) {

        }

    }};

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

    static DoubleSupplier parseFunctionAndJoin(String symbol, DoubleSupplier a) throws NotReadException {
        return joinFunctionAndValuable(parseFunction(symbol), a);
    }

    static DoubleSupplier joinFunctionAndValuable(DoubleUnaryOperator u, DoubleSupplier a) {
        return () -> u.applyAsDouble(a.getAsDouble());
    }

    static DoubleUnaryOperator parseFunction(String symbol) throws NotReadException {
        return FUNCTIONS.read(symbol);
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
