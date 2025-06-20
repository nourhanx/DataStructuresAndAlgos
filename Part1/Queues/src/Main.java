import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        reverseFirstK(q, 3);
        System.out.println(q);
//        System.out.println(q);
//        reverse(q);
//        System.out.println(q);
    }

    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void reverseFirstK(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }
    }
}