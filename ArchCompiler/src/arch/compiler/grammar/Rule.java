package arch.compiler.grammar;

import arch.compiler.ebnf.EBNFProduction;
import arch.tools.desingpattern.prototype.Prototype;
import arch.tools.io.Printable;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public interface Rule extends Printable, Prototype<Rule> {

    String getId();

    String getName();

    String getProduction();

    String getDescription();

    EBNFProduction getEBNFProduction();

    Map<String, Object> getPropertyMap();

    @Override
    default Rule cloneThis() {
        var rule = this;
        var propertyMap = new HashMap<>(getPropertyMap());
        return new Rule() {

            @Override
            public String getId() {
                return rule.getId();
            }

            @Override
            public String getName() {
                return rule.getName();
            }

            @Override
            public String getProduction() {
                return rule.getProduction();
            }

            @Override
            public String getDescription() {
                return rule.getDescription();
            }

            @Override
            public EBNFProduction getEBNFProduction() {
                return rule.getEBNFProduction();
            }

            @Override
            public Map<String, Object> getPropertyMap() {
                return propertyMap;
            }

            @Override
            public void printIn(PrintStream out) {
                rule.printIn(out);
            }

            @Override
            public String toString() {
                return rule.toString();
            }
        };
    }
}
