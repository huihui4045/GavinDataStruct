package hash;

/**
 * Created by gavin on 2018/1/11.
 * map的基类
 */
public interface IMap<K,V> {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void clear();
}
