package arch.compiler.info;

import arch.compiler.ast.ASTLexicalNode;
import arch.compiler.ast.ASTSyntaxNode;

import java.util.Objects;

public class InfoStation {

    private static InfoGenerator infoGenerator;

    static {
        InfoStation.infoGenerator = new DefaultInfoGenerator();
    }

    private InfoStation() {}

    public static void setInfoGenerator(InfoGenerator infoGenerator) {
        InfoStation.infoGenerator = Objects.requireNonNull(infoGenerator);
    }

    public static String generateInfoString(ASTLexicalNode astLexicalNode) {
        return infoGenerator.generateInfoString(astLexicalNode);
    }

    public static String generateInfoString(ASTSyntaxNode astSyntaxNode) {
        return infoGenerator.generateInfoString(astSyntaxNode);
    }

    public static String[] getBlockSymbols() {
        return infoGenerator.getBlockSymbols();
    }

}
