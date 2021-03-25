package arch.tools.collection.filler;

/**
 * BooleanFiller pertenece al grupo de las interfaces filler especialmente
 * pensadas para el llenado progresivo de cualquier tipo de colecciones
 * de datos booleanos incluidos los arreglos.
 * La estructura de una instacia filler es muy simple, únicamente
 * se debe implementar el método put. Es responsabilidad
 * de la clase implementadora definir el criterio de inserción de cada dato.
 */
@FunctionalInterface
public interface BooleanFiller {

    /**
     * Método abstracto que define la inserción del dato en la colección subyacente
     *
     * @param value el dato a insertar.
     */
    void put(boolean value);

    /**
     * Inserta los datos proporcionados en la colección subyacente
     *
     * @param values conjunto de datos a insertar.
     */
    default void putAll(boolean... values) {
        for (var value : values) put(value);
    }

}
