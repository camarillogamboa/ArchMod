package arch.compiler.lexical;

import arch.tools.collection.iterator.CharPointer;

public interface Automaton {

    Token recognize(CharPointer charPointer);

}
