import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLRU {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    CacheLRU(int capacity) {
        this. capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > CacheLRU.this.capacity;
            }
        };
    }

    int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    void put(int key, int value) {
        cache.put(key, value);
    }
}