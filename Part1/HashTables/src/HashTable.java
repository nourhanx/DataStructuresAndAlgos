import java.util.LinkedList;

public class HashTable {
    private class Entry {
        int key;
        String value;
        Entry (int k, String v) {
            key = k;
            value = v;
        }
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private LinkedList<Entry>[] map = new LinkedList[5];
    private int index;

    public void put(int k, String v) {
        index = hash(k);
        if(emptyIndex()) map[index] = new LinkedList<Entry>();

        for(Entry e : map[index]) {
            if (e.key == k) {
                e.value = v;
                return;
            }
        }
        map[index].addLast(new Entry(k, v));
    }
    public String get(int k) {
        index = hash(k);
        if(emptyIndex()) throw new IllegalStateException("No such key");
        for (Entry e: map[index]){
            if (e.key == k) return e.value;
        }
        return null;
    }
    public void remove(int k) {
        index = hash(k);
        if(emptyIndex()) throw new IllegalStateException(("No such key"));
        for(Entry e : map[index]){
            if (e.key == k){
                map[index].remove(e);
                return;
            }
        }
        throw new IllegalStateException("No such entry");
    }
    private boolean emptyIndex() {
        return map[index] == null;
    }

    private int hash (int k) {
        return k % map.length;
    }


}
