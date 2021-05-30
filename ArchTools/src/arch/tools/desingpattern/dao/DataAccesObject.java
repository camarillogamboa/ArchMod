package arch.tools.desingpattern.dao;

import arch.tools.object.NotCreationException;
import arch.tools.object.NotDeleteException;
import arch.tools.object.NotReadException;
import arch.tools.object.NotUpdateException;

public interface DataAccesObject<K,V> {

    boolean exists(K key);

    void create(K key, V value) throws NotCreationException;

    V read(K key) throws NotReadException;

    void update(K key, V value) throws NotUpdateException;

    void delete(K key) throws NotDeleteException;

}
