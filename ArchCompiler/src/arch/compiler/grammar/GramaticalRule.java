package arch.compiler.grammar;

import arch.compiler.ebnf.EBNFProduction;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GramaticalRule implements Rule {

    private final String id;
    private final String name;
    private final String production;
    private final String description;

    private final EBNFProduction ebnfProduction;

    private final Map<String, Object> propertyMap;

    GramaticalRule(String id, String name, String production, String description, Map<String, Object> propertyMap) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.production = Objects.requireNonNull(production);
        this.description = Objects.requireNonNull(description);

        this.ebnfProduction = null;

        this.propertyMap = Objects.requireNonNull(propertyMap);
    }

    public GramaticalRule(String id, String name, String production, String description) {
        this(id, name, production, description, new HashMap<>());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getProduction() {
        return production;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public EBNFProduction getEBNFProduction() {
        return ebnfProduction;
    }

    @Override
    public Map<String, Object> getPropertyMap() {
        return propertyMap;
    }

    @Override
    public void printIn(PrintStream out) {

    }

    @Override
    public String toString() {
        return name + ":= " + production;
    }
}
