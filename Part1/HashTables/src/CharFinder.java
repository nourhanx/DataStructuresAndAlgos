import java.util.HashMap;
import java.util.HashSet;

public class CharFinder {


    public Character firstNonRepeatedChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count;
        char[] charArr = s.toCharArray();
        for (Character ch: charArr) {
            count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, ++count);
        }
        for (Character ch: charArr) {
            if (map.get(ch) == 1) return ch;
        }
        return Character.MIN_VALUE;
    }

    public Character firstRepeatedChar(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] charArr = s.toCharArray();
        for(Character ch : charArr) {
            if (set.contains(ch)) return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

}
