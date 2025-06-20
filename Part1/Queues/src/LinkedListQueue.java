import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> q;
    int count = 0;

    LinkedListQueue() {
        q = new LinkedList<>();
    }

    // enqueue
    public void enqueue(int val) {
        q.addLast(val);
        count++;
    }
    // dequeue
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        int val = q.getFirst();
        count--;
        q.removeFirst();
        return val;
    }
    // peek
    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return q.getFirst();
    }
    // size
    public int size(){
        return count;
    }
    // isEmpty
    public boolean isEmpty() {
        return count == 0;
    }
}
