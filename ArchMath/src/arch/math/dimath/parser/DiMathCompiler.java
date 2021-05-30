package arch.math.dimath.parser;

import arch.math.dimath.DiMathException;
import arch.math.dimath.DiMathLambdaSet;
import arch.math.dimath.Lexeme;
import arch.math.dimath.SignatureSet;
import arch.tools.io.textfile.TextFileDAO;
import arch.tools.StringUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class DiMathCompiler {

    public static List<Lexeme> compileExpression(String source) throws DiMathException {
        return compileExpression(StringUtil.toInputStream(source));
    }

    public static List<Lexeme> compileExpression(InputStream input) throws DiMathException {
        var expr = new LinkedList<Lexeme>();
        var dimath = new DiMath(input);
        try {
            dimath.Expression(expr);
        } catch (ParseException e) {
            throw new DiMathException(e);
        }
        return expr;
    }

    public static List<List<Lexeme>> compileBody(String source) throws DiMathException {
        return compileBody(StringUtil.toInputStream(source));
    }

    public static List<List<Lexeme>> compileBody(InputStream input) throws DiMathException {
        var exprMatrix = new LinkedList<List<Lexeme>>();

        var dimath = new DiMath(input);
        try {
            dimath.Body(exprMatrix);
        } catch (ParseException e) {
            throw new DiMathException(e);
        }
        return exprMatrix;
    }

    public static SignatureSet compileSignature(String source) throws DiMathException {
        return compileSignature(StringUtil.toInputStream(source));
    }

    public static SignatureSet compileSignature(InputStream input) throws DiMathException {
        var vars = new LinkedList<Lexeme>();
        var facts = new HashMap<Lexeme, Lexeme>();

        var dimath = new DiMath(input);

        try {
            dimath.Signature(vars, facts);
        } catch (ParseException e) {
            throw new DiMathException(e);
        }
        return new SignatureSet(vars, facts);
    }

    public static DiMathLambdaSet compileLambdaExpression(String source) throws DiMathException {
        return compileLambdaExpression(StringUtil.toInputStream(source));
    }

    public static DiMathLambdaSet compileLambdaExpression(File file) throws DiMathException {
        if (file.getName().endsWith(".dimath")) {
            try {
                return compileLambdaExpression(TextFileDAO.in(file));
            } catch (IOException e) {
                throw new DiMathException(e);
            }
        } else throw new IllegalArgumentException("El archivo a compilar especificado no es de extensión .dimath");
    }

    public static DiMathLambdaSet compileLambdaExpression(InputStream input) throws DiMathException {

        var vars = new LinkedList<Lexeme>();
        var facts = new HashMap<Lexeme, Lexeme>();
        var exprMatrix = new LinkedList<List<Lexeme>>();

        var dimath = new DiMath(input);

        try {
            dimath.DiMathLambda(vars, facts, exprMatrix);
        } catch (ParseException e) {
            throw new DiMathException(e);
        }

        return new DiMathLambdaSet(new SignatureSet(vars, facts), exprMatrix);
    }


}
