import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    ArrayList<Integer> toPrint = new ArrayList<>();

    QueueWithTwoStacks(){

    }

    public void enqueue(int val) {
        s1.push(val);
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        moveStack1ToStack2();
        return s2.pop();
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        moveStack1ToStack2();
        return s2.peek();
    }

    private void moveStack1ToStack2() {
        if (s2.empty()){
            while (!s1.empty()) s2.push(s1.pop());
        }
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    @Override
    public String toString() {
        ArrayList<Integer> result = new ArrayList<>();

        // Print elements from s2 (front of queue)
        for (int i = s2.size() - 1; i >= 0; i--) {
            result.add(s2.get(i));
        }

        // Print elements from s1 (newly enqueued, in reverse)
        for (int i = 0; i < s1.size(); i++) {
            result.add(s1.get(i));
        }

        return result.toString();
    }



    public static void main(String[] args) {
        QueueWithTwoStacks q = new QueueWithTwoStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q);
    }
}
