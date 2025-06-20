import java.util.Arrays;

public class PriorityQueue {
    private int[] q;
    int count = 0;

    PriorityQueue() {
        q = new int[5];
    }

    public void enqueue(int val) {

        if (isFull()) resize();
        int i = shiftItemsToInsert(val);
        q[i] = val;
        count++;
    }

    public boolean isFull() {
        return count == q.length;
    }

    private int shiftItemsToInsert(int val) {
        int i = count - 1;
        while (i >= 0 && q[i] > val) {
            q[i + 1] = q[i];
            i--;
        }
        return i + 1;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return q[--count];
    }

    public int peek() {
        return q[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void resize() {
        int[] temp = new int[q.length * 2];
        for (int i = 0; i < count; i++) {
            temp[i] = q[i];
        }
        q = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(q, 0, count));
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        // Enqueue elements
        pq.enqueue(30);
        pq.enqueue(10);
        pq.enqueue(50);
        pq.enqueue(20);
        pq.enqueue(40);

        // Print the queue (should be in ascending order)
        System.out.println("PriorityQueue after enqueues: " + pq);  // Expected: [10, 20, 30, 40, 50]

        // Peek
        System.out.println("Peek: " + pq.peek()); // Expected: 50 (highest priority)

        // Dequeue
        System.out.println("Dequeued: " + pq.dequeue()); // Expected: 50
        System.out.println("PriorityQueue after one dequeue: " + pq);  // Expected: [10, 20, 30, 40]

        // Dequeue all
        while (!pq.isEmpty()) {
            System.out.println("Dequeued: " + pq.dequeue());
        }

        // Final check
        System.out.println("Is empty? " + pq.isEmpty()); // Expected: true
        System.out.println("PriorityQueue now: " + pq);  // Expected: []
    }

}

