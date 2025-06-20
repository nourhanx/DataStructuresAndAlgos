import com.sun.jdi.CharType;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        String s = "a green apple";
//        CharFinder myCharFinder = new CharFinder();
//        Character ch = myCharFinder.firstNonRepeatedChar("a green apple");
//        System.out.println(ch);
//        ch = myCharFinder.firstRepeatedChar("a green apple");
//        System.out.println(ch);

        HashTable t = new HashTable();
        t.put(6, "A"); //1
        t.put(8, "B"); //3
        t.put(11, "C"); //1
        t.put(6, "A+");
        t.remove(60);
        System.out.println(t.get(10));
    }


}