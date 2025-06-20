import java.util.Arrays;

public class ArrayQueue {
    int[] q;
    int count = 0;
    int size = 0;
    private int front = 0;
    private int rear = 0;

    ArrayQueue(int size) {
        q = new int[size];
        this.size = size;
    }

    //enqueue
    public void enqueue(int val) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        q[rear] = val;
        rear = (rear + 1) % size;
        count++;
    }
    //dequeue
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        int val = q[front];
        front = (front + 1) % size;
        return val;

    }
    //peek
    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return q[front];
    }
    //isEmpty
    public boolean isEmpty() {
        return count == 0;
    }
    //isFull
    public boolean isFull() {
        return count == size;
    }

}
