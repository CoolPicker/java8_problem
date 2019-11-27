package com.collectors;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * 基于HashSet创建HashMap
 * @param <K>
 * @param <V>
 *
 * 对于HashSet而言，系统采用Hash算法决定集合元素的存储位置，可以保证快速存、取集合元素；
 * 对于HashMap而言，系统将value当做key的附属物，系统将根据Hash算法来决定key的存储位置，
 * 这样可以保证快速存、取元素key，而value总是紧随key存储。
 * 注：集合存储的其实时Java对象的引用而已，即Java集合时多个引用变量组成的集合，
 * 这些引用变量指向实际的Java对象。
 */
public class Set2Map<K,V> extends HashSet<SimpleEntry<K,V>> {
    // 实现清空所有key-value 对的方法
    public void clear() {
        super.clear();
    }
    // 判断是否包含某个key
    public boolean containsKey(K key) {
        return super.contains(new SimpleEntry<>(key,null));
    }

    // 判断是否包含某个value
    boolean containsValue(Object value) {
        for(SimpleEntry<K,V> se : this) {
            if (se.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    // 根据指定的key取出对应的value
    public V get(Object key) {
        for(SimpleEntry<K,V> se : this) {
            if (se.getKey().equals(key)) {
                return se.getValue();
            }
        }
        return null;
    }

    public void put(K key,V value) {
        add(new SimpleEntry<>(key,value));
    }

    public void putAll(Map<? extends K,? extends V> m) {
        for (K key : m.keySet()) {
            add(new SimpleEntry<>(key,m.get(key)));
        }
    }

    public V removeEntry(Object key) {
        for (Iterator<SimpleEntry<K,V>> it = this.iterator();it.hasNext();){
            SimpleEntry<K,V> en = it.next();
            if (en.getKey().equals(key)) {
                V v = en.getValue();
                it.remove();
                return v;
            }
        }
        return null;
    }

    public int size(){
        return super.size();
    }
}

class SimpleEntry<K,V> implements Map.Entry<K,V>,java.io.Serializable{
    private final K key;
    private V value;

    // 定义构造器
    public SimpleEntry(K key,V value) {
        this.key = key;
        this.value = value;
    }

    public SimpleEntry(Map.Entry<? extends K,? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
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
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleEntry<?, ?> that = (SimpleEntry<?, ?>) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "SimpleEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
