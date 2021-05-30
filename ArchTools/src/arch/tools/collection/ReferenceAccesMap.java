package arch.tools.collection;

import arch.tools.desingpattern.dao.DataAccesObject;
import arch.tools.object.NotCreationException;
import arch.tools.object.NotDeleteException;
import arch.tools.object.NotReadException;
import arch.tools.object.NotUpdateException;

import java.util.HashMap;
import java.util.Map;

public class ReferenceAccesMap<K, V> implements DataAccesObject<K, V> {

    private final Map<K, V> map;

    public ReferenceAccesMap() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean exists(K key) {
        return map.containsKey(key);
    }

    @Override
    public void create(K key, V value) throws NotCreationException {
        if (exists(key)) throw new NotCreationException();
        map.put(key, value);
    }

    @Override
    public V read(K key) throws NotReadException {
        var value = map.get(key);
        if (value != null) return value;
        else throw new NotReadException();
    }

    @Override
    public void update(K key, V value) throws NotUpdateException {
        if (map.replace(key, value) == null) throw new NotUpdateException();
    }

    @Override
    public void delete(K key) throws NotDeleteException {
        if (map.remove(key) == null) throw new NotDeleteException();
    }

}
