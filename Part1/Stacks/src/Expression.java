import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> openBrackets = Arrays.asList('(', '[', '{', '<');
    private final List<Character> closedBrackets = Arrays.asList(')', ']', '}', '>');

    public boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (isOpenBracket(c)) stack.push(c);
            else if (isClosedBracket(c)){
                if (stack.empty()) return false;
                char top = stack.peek();
                if (!isMatched(top, c)) return false;
                else stack.pop();
            }
        }
        return stack.empty();
    }
    private boolean isOpenBracket(char c) {
        return openBrackets.contains(c);
    }
    private boolean isClosedBracket(char c) {
        return closedBrackets.contains(c);
    }
    private boolean isMatched(char open, char closed) {
        return openBrackets.indexOf(open) == closedBrackets.indexOf(closed);
    }
}

