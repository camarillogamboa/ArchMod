package arch.math.dimath;

import arch.math.dimath.parser.DiMathCompiler;
import arch.tools.collection.LinkedStack;
import arch.tools.collection.array.Arrays;
import arch.tools.collection.node.EntryNodeBase;
import arch.tools.collection.table.IndexedTable;

import java.io.File;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Supplier;

public final class DiMathLambda implements Supplier<double[]>, Function<double[],double[]> {

    private final IndexedTable<String, Variable> parameters;
    private final DoubleSupplier[] expressionTrees;

    public DiMathLambda(IndexedTable<String, Variable> parameters, IndexedTable<String, DoubleSupplier> factors, PostfixExpression[] postfixExpressions) throws DiMathException {
        this.parameters = Objects.requireNonNull(parameters);
        Objects.requireNonNull(factors);
        Objects.requireNonNull(postfixExpressions);

        if (postfixExpressions.length == 0)
            throw new DiMathException("Debe proporcionar al menos una expresión postfija");

        this.expressionTrees = new DoubleSupplier[postfixExpressions.length];

        for (int i = 0; i < expressionTrees.length; i++) {

            var s = new LinkedStack<EntryNodeBase<String, DoubleSupplier>>();

            try {
                for (var l : postfixExpressions[i]) {
                    var sy = l.toString();
                    DoubleSupplier ds;
                    switch (l.getKind()) {
                        case PARAMETER_FACTOR_REFERENCE -> {
                            if ((ds = parameters.get(sy)) == null && (ds = factors.get(sy)) == null)
                                throw new IllegalArgumentException("Referencia a variable o factor \"" + sy + "\" no declarado");
                        }
                        case FUNCTION_REFERENCE -> ds = null;
                        case INT_LIT, FLOAT_LIT -> ds = DiMathUtil.parseLiteral(sy);
                        case OPERATOR -> {
                            var a = s.pop();
                            var b = s.pop();
                            ds = "<".equals(sy) ? DiMathUtil.parseFunctionAndJoin(b.getKey(), a.getValue()) : DiMathUtil.parseOperatorAndJoin(sy, b.getValue(), a.getValue());
                        }
                        default -> throw new IllegalArgumentException("Tipo de lexema no admitido");
                    }
                    s.push(new EntryNodeBase<>(sy, ds));
                }
            } catch (Exception ex) {
                throw new DiMathException(ex);
            }

            this.expressionTrees[i] = s.pop().getValue();
        }

    }

    public DiMathLambda(SignatureSet signatureSet, PostfixExpression[] postfixExpressions, DoubleSupplier... externals) throws DiMathException {
        this(DiMathUtil.toIndexedTable(signatureSet.vars()), DiMathUtil.toIndexedTable(signatureSet.factors(), Arrays.readOnlyArrayOf(externals)), postfixExpressions);
    }

    public DiMathLambda(SignatureSet signatureSet, InfixExpression[] infixExpressions, DoubleSupplier... externals) throws DiMathException {
        this(DiMathUtil.toIndexedTable(signatureSet.vars()), DiMathUtil.toIndexedTable(signatureSet.factors(), Arrays.readOnlyArrayOf(externals)), DiMathUtil.mapEachToPostfixExpression(infixExpressions));
    }

    public DiMathLambda(SignatureSet signatureSet, List<List<Lexeme>> exprMatrix, DoubleSupplier... externals) throws DiMathException {
        this(signatureSet, exprMatrix.stream().map(InfixExpression::new).toArray(InfixExpression[]::new), externals);
    }

    public DiMathLambda(DiMathLambdaSet diMathLambdaSet, DoubleSupplier... externals) throws DiMathException {
        this(diMathLambdaSet.signatureSet(), diMathLambdaSet.expressions(), externals);
    }

    public DiMathLambda(String lambdaExpression, DoubleSupplier... externals) throws DiMathException {
        this(DiMathCompiler.compileLambdaExpression(lambdaExpression), externals);
    }

    public DiMathLambda(File sourceFile, DoubleSupplier... externals) throws DiMathException {
        this(DiMathCompiler.compileLambdaExpression(sourceFile), externals);
    }

    public IndexedTable<String, Variable> getParameters() {
        return parameters;
    }

    public void setValueOf(String id, double value) {
        var var = parameters.get(id);
        if (var != null) var.setValue(value);
        else throw new IllegalArgumentException("Referencia a variable \"" + id + "\" no encontrada");
    }

    public void setParameterValues(double... paremeterValues) {
        var variables = parameters.getValues();
        if (variables.size() == paremeterValues.length)
            for (int i = 0; i < variables.size(); i++) variables.valueOf(i).setValue(paremeterValues[i]);
        else throw new IllegalArgumentException("Número de valores incompatible");
    }

    @Override
    public double[] get() {
        var image = new double[expressionTrees.length];

        for (int i = 0; i < image.length; i++) image[i] = expressionTrees[i].getAsDouble();
        return image;
    }

    @Override
    public double[] apply(double... a) {
        setParameterValues(a);
        return get();
    }

    public Consumer<OrderedPair> createImpresor(PrintStream out) {
        return new OrderedPairImpresor(out, parameters.getKeys());
    }

    public Consumer<OrderedPair> createImpresor() {
        return createImpresor(System.out);
    }

}
