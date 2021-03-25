package arch.tools.collection.filler;

/**
 * DoubleFiller pertenece al grupo de las interfaces filler especialmente
 * pensadas para el llenado progresivo de cualquier tipo de colecciones de
 * flotantes dobles incluidos los arreglos.
 * La estructura de una instacia filler es muy simple, únicamente
 * se debe implementar el método put. Es responsabilidad
 * de la clase implementadora definir el criterio de inserción de cada dato.
 */
@FunctionalInterface
public interface DoubleFiller {

    /**
     * Método abstracto que define la inserción del dato en la colección subyacente
     *
     * @param value el dato a insertar.
     */
    void put(double value);

    /**
     * Inserta los datos proporcionados en la colección subyacente
     *
     * @param values conjunto de datos a insertar.
     */
    default void putAll(double... values) {
        for (var value : values) put(value);
    }

}
