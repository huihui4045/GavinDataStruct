package hash;

/**
 * Created by gavin on 2018/1/11.
 * <p>
 * 手写hashMap
 */
public class AliHashMap<K, V> implements IMap<K, V> {


    /***
     * 最大
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;


    private HashMapEntry<K, V>[] table = null;

    /****
     * 默认大小
     */
    static final int DEFAULT_INITIAL_CAPACITY = 4;

    /***
     * 填装因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    final float loadFactor = DEFAULT_LOAD_FACTOR;


    int threshold;

    /***
     * 数据的个税
     */
    int size;

    public AliHashMap(int initialCapacity, float loadFactor) {


        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        } else if (initialCapacity < DEFAULT_INITIAL_CAPACITY) {
            initialCapacity = DEFAULT_INITIAL_CAPACITY;
        }

        threshold = initialCapacity;


    }

    public AliHashMap() {

        this(4,DEFAULT_LOAD_FACTOR);
    }

    private void inflateTable(int toSize) {

        float thresholdFloat = toSize * loadFactor;
        if (thresholdFloat > MAXIMUM_CAPACITY + 1) {
            thresholdFloat = MAXIMUM_CAPACITY + 1;
        }
        threshold = (int) thresholdFloat;


        table = new HashMapEntry[toSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {

        if (key == null) {

            return getForNullKey();
        }

        HashMapEntry<K, V> entry = getEntry(key);


        return null == entry ? null : entry.getValue();
    }

    @Override
    public V put(K key, V value) {

        if (table == null) {

            inflateTable(threshold);
        }

        if (key == null) {

            return putForNullKey(value);
        }


        int hash = hash(key);

        int index = indexFor(hash, table.length);


        for (HashMapEntry<K, V> e = table[index]; e != null; e = e.next) {


            Object k;

            if ((e.hash == hash) && ((k=e.key) == key || key.equals(k))) {

                V oldValue = e.value;

                e.value = value;



                return oldValue;
            }
        }


        addEntry(hash, key, value, index);


        return null;
    }


    public V getForNullKey() {

        if (size == 0) return null;

        for (HashMapEntry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.getValue();
        }


        return null;
    }


    private HashMapEntry<K, V> getEntry(Object key) {

        if (size == 0) return null;

        int hash = hash(key);

        int index = indexFor(hash, table.length);
        for (HashMapEntry<K, V> e = table[index]; e != null; e = e.next) {

            Object k = e.key;

            if ((e.hash == hash) && (k == key || key.equals(k))) {


                return e;
            }
        }


        return null;
    }

    private V putForNullKey(V value) {


        for (HashMapEntry<K, V> e = table[0]; e != null; e = e.next) {

            if (e.key == null) {

                V old = e.getValue();

                e.value = value;

                return old;
            }
        }

        addEntry(0, null, value, 0);


        return null;
    }


    /***
     *
     * @param hash    hash值
     * @param key
     * @param value
     * @param bucketIndex  需要插入的数组下标
     */
    void addEntry(int hash, K key, V value, int bucketIndex) {


        if ((size > threshold) && (null != table[bucketIndex])) {

            resize(2 * table.length);

            hash = hash(key);

            bucketIndex = indexFor(hash, table.length);
        }

        createEntry(hash, key, value, bucketIndex);

    }

    /****
     * 创建节点
     * @param hash
     * @param key
     * @param value
     * @param bucketIndex  在数组 这个位置插入一个节点
     */
    void createEntry(int hash, K key, V value, int bucketIndex) {

        HashMapEntry<K, V> e = table[bucketIndex];

        table[bucketIndex] = new HashMapEntry<>(hash, key, value, e);

        size++;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int indexFor(int h, int length) {
        // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
        return h & (length - 1);
    }


    /***
     * 扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        System.out.println(" 扩容  newCapacity = [" + newCapacity + "]");

        HashMapEntry[] oldTable=table;
        int oldCapacity=oldTable.length;
        if (oldCapacity>=MAXIMUM_CAPACITY){
            threshold=Integer.MAX_VALUE;
            return;
        }

        HashMapEntry<K,V>[] newTable=new HashMapEntry[newCapacity];

        for (HashMapEntry<K,V> e:table){

            while (null!=e){

                HashMapEntry<K,V> next=e.next;

                int index=indexFor(e.hash,newCapacity);

                e.next=newTable[index];
                newTable[index]=e;

                e=next;
            }
        }

        table=newTable;


        threshold= (int) Math.min(newCapacity*loadFactor,MAXIMUM_CAPACITY+1);

    }

    @Override
    public V remove(Object key) {

        HashMapEntry<K,V> e=removeEntryForKey(key);


        return (e==null?null:e.getValue());
    }

    private  HashMapEntry<K,V> removeEntryForKey(Object key) {
        if (size()==0)return null;
        int hash=(key==null)?0:hash(key);
        int index=indexFor(hash,table.length);
        HashMapEntry<K,V>  prev=table[index];
        HashMapEntry<K,V> e=prev;

        while (null!=e){
            HashMapEntry<K,V> next=e.next;

            Object k=e.key;
            if (e.hash==hash&&(k==key||key.equals(k))){

                if (prev==e){
                    table[index]=next;
                }else {
                    prev.next=next;
                }

                size--;

                return e;
            }
            prev=e;
            e=next;
        }




        return null;
    }

    @Override
    public void clear() {

    }


    static class HashMapEntry<K, V> {

        final K key;
        V value;
        HashMapEntry<K, V> next;
        int hash;

        /**
         * Creates new entry.
         */
        HashMapEntry(int hash, K key, V value, HashMapEntry<K, V> next) {
            this.value = value;
            next = next;
            this.key = key;
            this.hash = hash;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {


            if (!(o instanceof HashMapEntry)) {

                return false;
            }

            HashMapEntry e = (HashMapEntry) o;

            Object key1 = getKey();

            Object key2 = e.getKey();

            if (key1 == key1 || (key1 != null && key1.equals(key2))) {

                Object v1 = getValue();

                Object v2 = e.getValue();

                if (v1 == v2 || (v1 != null && v1.equals(v2))) {

                    return true;
                }
            }


            return false;
        }
    }
}
