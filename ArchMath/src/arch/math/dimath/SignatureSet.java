package arch.math.dimath;

import java.util.List;
import java.util.Map;

public record SignatureSet(List<Lexeme> vars, Map<Lexeme, Lexeme> factors) {}
