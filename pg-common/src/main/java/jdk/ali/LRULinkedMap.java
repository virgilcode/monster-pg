package jdk.ali;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Starstar Sun
 * @date 2018/8/16 13:40
 * @Description:基于linkedHashMap实现最近最少使用
 **/
public class LRULinkedMap<K, V> {

    private int cacheSize;

    private LinkedHashMap<K, V> cacheMap;

    public LRULinkedMap(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cacheMap = new LinkedHashMap(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (cacheSize + 1 == cacheMap.size()) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

    public void put(K key, V value) {
        cacheMap.put(key, value);
    }

    public V get(K key) {
        return cacheMap.get(key);
    }

    public Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(cacheMap.entrySet());
    }

    public static void main(String[] args) {
        LRULinkedMap<String, Integer> map = new LRULinkedMap(3);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        for (Map.Entry<String, Integer> e : map.getAll()) {
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
        System.out.println(" ");
        map.put("4", 4);
        System.out.println(map.get("2"));
        for (Map.Entry<String, Integer> e : map.getAll()) {
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
    }
}
