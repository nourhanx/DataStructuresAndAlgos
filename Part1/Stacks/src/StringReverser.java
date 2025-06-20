import java.util.Stack;

public class StringReverser {
    public static String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuffer reversed = new StringBuffer("");

        while (!stack.empty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
