package arch.tools.collection.filler;

/**
 * IntFiller pertenece al grupo de las interfaces filler especialmente
 * pensadas para el llenado progresivo de cualquier tipo de colecciones de
 * flotantes incluidos los arreglos.
 * La estructura de una instacia filler es muy simple, únicamente
 * se debe implementar el método put. Es responsabilidad
 * de la clase implementadora definir el criterio de inserción de cada dato.
 */
@FunctionalInterface
public interface IntFiller {

    void put(int value);

    default void putAll(int... values) {
        for (var value : values) put(value);
    }

}
