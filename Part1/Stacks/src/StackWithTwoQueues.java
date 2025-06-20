import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private int count = 0;

    // push
    public void push(int val) {
        if(q2.isEmpty()) q1.add(val);
        else q2.add(val);
        count++;
    }
    // pop
    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        int i = count;
        count--;
        if (q2.isEmpty()) {
            return moveAndPop(q1, q2);
        }
        else {
            return moveAndPop(q2, q1);
        }
    }

    private int moveAndPop(Queue<Integer> source, Queue<Integer> target) {
        int i = source.size();
        while (i > 1) {
            target.add(source.remove());
            i--;
        }
        return source.remove();
    }

    // peek
    // size
    public int size() {
        return count;
    }
    // isEmpty
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
