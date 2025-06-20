public class HashTableWithLinearProbing {
    private String[] hashTable = new String[5];
    int hashValue;
    int count = 0;

    // put
    public void put(String val) {
        hashValue = hash(val);

        if(hashTable[hashValue] == null) {
            hashTable[hashValue] = val;
            count++;
        }
        else probe(val);
    }
    // get
    public String get(int index) {
        return hashTable[index];
    }
    // remove
    public void remove(int index) {
        hashTable[index] = null;
        count--;
    }

    // size
    public int size() {
        return count;
    }
    public int hash(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (char ch : chars) sum+=ch;
        return sum % hashTable.length;
    }
    public void probe(String val) {
        for (int i = 0; i < hashTable.length; i++) {
            hashValue = (hashValue + 1) % hashTable.length;
            if (hashTable[hashValue] == null) {
                hashTable[hashValue] = val;
                count++;
                return;
            }
        }
        throw new IllegalStateException("HashTable is full");
    }
}
