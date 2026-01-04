package com.laychv.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

}
