package datastructures;

import java.util.*;

public class CustomHashTable<K,V> {
    
    private final static int DEFAULT_CAPACITY = 16;
    
    private final static double DEFAULT_GROWTH_FACTOR = 0.75;

    private int size;

    private int capacity;

    private double growthFactor;

    private HashNode[] buckets;
    
    private class HashNode<K, V> implements Map.Entry<K,V> {
        K key;
        V value;
        HashNode<K,V> next;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HashNode)) return false;

            HashNode<?, ?> hashNode = (HashNode<?, ?>) o;

            return key.equals(hashNode.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
    
    public CustomHashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_GROWTH_FACTOR);
    }
    
    public CustomHashTable(int capacity) {
        this(capacity, DEFAULT_GROWTH_FACTOR);
    }

    public CustomHashTable(int capacity, double growthFactor) {
        this.buckets = new HashNode[capacity];
        this.capacity = capacity;
        this.growthFactor = growthFactor;
    }

    public void clear() {
        this.size = 0;
        this.buckets = new HashNode[capacity];
    }

    public boolean contains(Object value) {
        return containsValue(value);
    }

    public boolean containsKey(Object key) {
        int bucketIdx = getIndex(key);
        HashNode<K,V> curEntry = getNode((K) key, bucketIdx);
        return curEntry != null && curEntry.key.equals(key);
    }

    public boolean containsValue(Object value) {

        for(HashNode curNode : this.buckets) {
            if(curNode == null) {
                continue;
            }

            while(curNode != null) {
                if(curNode.value.equals(value)) {
                    return true;
                }
                curNode = curNode.next;
            }

        }
        return false;
    }

    public Set<Map.Entry<K,V>> entrySet () {
        Set<Map.Entry<K, V>> result = new HashSet<>();
        for(HashNode curNode : this.buckets) {
            if(curNode == null) {
                continue;
            }
            while(curNode != null) {
                result.add(curNode);
                curNode = curNode.next;
            }

        }
        return result;
    }

    public V get(Object key) {
        HashNode curNode = this.buckets[getIndex(key)];
        while(curNode != null && !curNode.key.equals(key)) {
            curNode = curNode.next;
        }
        return curNode != null ? (V)curNode.value : null;
    }

    public V getOrDefault(Object key, V defaultValue) {
        HashNode curNode = this.buckets[getIndex(key)];
        while(curNode != null && !curNode.key.equals(key)) {
            curNode = curNode.next;
        }
        return curNode != null ? (V)curNode.value : defaultValue;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for(HashNode curNode : this.buckets) {
            if(curNode == null) {
                continue;
            }
            while(curNode != null) {
                result.add((K) curNode.key);
                curNode = curNode.next;
            }

        }
        return result;
    }

    private HashNode<K,V> getNode(K key, int bucketIdx) {

        HashNode curNode = this.buckets[bucketIdx];
        while(curNode != null && curNode.next != null) {
            if(curNode.key.equals(key)) {
                return curNode;
            }
            curNode = curNode.next;
        }

        return curNode;
    }

    private void increaseCapacityIfNeed() {
        if(this.size <= (int)(growthFactor * this.capacity)) {
            return;
        }

        resize(this.capacity * 2);
    }

    private void decreaseCapacityIfNeed() {
        if(this.size >= (int)(0.25 * this.capacity)) {
            return;
        }

        int newCapacity = Math.max(this.capacity / 2, DEFAULT_CAPACITY);
        resize(newCapacity);
    }

    private void resize(int newCapacity) {

        HashNode[] oldBuckets = this.buckets;

        this.buckets = new HashNode[newCapacity];
        this.capacity = newCapacity;

        for(HashNode<K,V> node : oldBuckets) {
            HashNode<K,V> curNode = node;
            while(curNode != null) {
                int newIdx = getIndex(curNode.key);
                if (this.buckets[newIdx] == null) {
                    this.buckets[newIdx] = new HashNode<>(curNode.key, curNode.value);
                }
                else {
                    HashNode<K,V> iterNode = this.buckets[newIdx];
                    while (iterNode.next != null) {
                        iterNode = iterNode.next;
                    }
                    iterNode.next = new HashNode<>(curNode.key, curNode.value);
                }
                curNode = curNode.next;
            }
        }
        ;
    }

    public V put(K key, V value) {
        int bucketIdx = getIndex(key);
        HashNode<K,V> curEntry = getNode(key, bucketIdx);

        //replace value
        if(curEntry != null && curEntry.key.equals(key)) {
            curEntry.value = value;
        }
        else if (curEntry != null) {
            curEntry.next = new HashNode<>(key, value);
            this.size++;
            increaseCapacityIfNeed();
        }
        else {
            this.buckets[bucketIdx] = new HashNode<>(key, value);
            this.size++;
            increaseCapacityIfNeed();
        }

        return value;
    }

    public V putIfAbsent(K key, V value) {
        int bucketIdx = getIndex(key);
        HashNode<K,V> curEntry = getNode(key, bucketIdx);

        //existing entry with the same key found
        if(curEntry != null && curEntry.key.equals(key)) {
            return curEntry.value;
        }

        HashNode<K,V> newEntry = new HashNode<>(key, value);

        if(curEntry == null) {
            this.buckets[bucketIdx] = newEntry;
        }
        else {
            curEntry.next = newEntry;
        }

        this.size++;

        increaseCapacityIfNeed();

        return value;
    }

    public V remove(Object key) {
        int bucketIdx = getIndex(key);
        HashNode<K,V> curNode = this.buckets[bucketIdx];
        HashNode<K,V> prevNode = null;
        while(curNode != null && !curNode.key.equals(key)) {
            prevNode = curNode;
            curNode = curNode.next;
        }

        if(curNode != null) {
            if(prevNode != null) {
                prevNode.next = curNode.next;
            }
            else if(curNode.next != null) {
                this.buckets[bucketIdx] = curNode.next;
            }
            else {
                this.buckets[bucketIdx] = null;
            }

            this.size--;
            decreaseCapacityIfNeed();

            return curNode.value;
        }

        return null;
    }

    public boolean remove(Object key, Object value) {
        int bucketIdx = getIndex(key);
        HashNode<K,V> curNode = this.buckets[bucketIdx];
        HashNode<K,V> prevNode = null;
        while(curNode != null && !(curNode.key.equals(key) && curNode.value.equals(value))) {
            prevNode = curNode;
            curNode = curNode.next;
        }

        if(curNode != null) {
            if(prevNode != null) {
                prevNode.next = curNode.next;
            }
            else if(curNode.next != null) {
                this.buckets[bucketIdx] = curNode.next;
            }
            else {
                this.buckets[bucketIdx] = null;
            }

            this.size--;
            decreaseCapacityIfNeed();

            return true;
        }

        return false;
    }

    public V replace(K key, V value) {
        int bucketIdx = getIndex(key);
        HashNode<K,V> curEntry = getNode(key, bucketIdx);
        if(curEntry != null && curEntry.key.equals(key)) {
            V previousValue = curEntry.value;
            curEntry.value = value;
            return previousValue;
        }
        return null;
    }

    public boolean replace(K key, V oldValue, V newValue) {
        int bucketIdx = getIndex(key);
        HashNode<K,V> curEntry = getNode(key, bucketIdx);
        if(curEntry != null && curEntry.key.equals(key) && curEntry.value.equals(oldValue)) {
            curEntry.value = newValue;
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public Collection<V> values() {
        ArrayList<V> result = new ArrayList<>();
        for(HashNode curNode : this.buckets) {
            if(curNode == null) {
                continue;
            }
            while(curNode != null) {
                result.add((V) curNode.value);
                curNode = curNode.next;
            }
        }
        return result;
    }

    private int getIndex(Object key) {
        return (key.hashCode() & 0x7FFFFFFF) % this.buckets.length;
    }

}
