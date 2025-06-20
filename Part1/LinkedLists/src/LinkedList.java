import java.lang.annotation.IncompleteAnnotationException;
import java.util.NoSuchElementException;

public class LinkedList {
    private static class Node {
        private final int value;
        private Node next;

        Node(int val){
            value = val;
            next = null;
        }
    }

    private  Node first = null;
    private Node last = null;
    private int size;

    LinkedList(int val) {
        first = last = new Node(val);
        size = 1;
    }

    private boolean isEmpty(){
        return first == null ;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        size++;
        if (isEmpty()) {
            first = last = node;
            return;
        }
        node.next = first;
        first = node;
    }

    public void addLast(int val) {
        size++;
        Node node = new Node(val);
        if (isEmpty()) {
            first = last = node;
            return;
        }
        last.next = node;
        last = node;
    }

    private Node getPrevious(Node node) {
        Node curr = first;
        while (curr != null) {
            if (curr.next == node) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        if (first == last) {
            first = last = null;
            return;
        }
        Node second = first.next;
        first.next = null;
        first = second;
    }

    public void deleteLast(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        if (first == last) {
            first = last = null;
            return;
        }
        last = getPrevious(last);
        last.next = null;
    }

    public boolean contains(int val) {
        return indexOf(val) != -1;
    }

    public int indexOf(int val) {
        Node curr = first;
        int index = 0;
        while (curr != null) {
            if (curr.value == val)
                return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getSize() {
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        Node curr = first;
        int index = 0;
        while(curr != null) {
            arr[index++] = curr.value;
            curr = curr.next;
        }
        return arr;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        Node previous = first;
        Node current = previous.next;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();
        if (k > size) throw new IllegalArgumentException();

        Node l;
        Node m;

        l = first;
        m = first;
        for (int i = 0; i < k - 1; i++) {
            m = m.next;
        }

        // now we have the two pointers positioned correctly

        while (m.next != null) {
            l = l.next;
            m = m.next;
        }
        return l.value;

    }

    public int[] printMiddle() {
        // 4   5   6   7   8   8   7   8   9   6
        // ^^
        //     ^   ^
        //         ^       ^
        //             ^           ^
        //                 ^                ^
        if (isEmpty()) throw new IllegalStateException();
        Node middle, last;
        middle = last = first;

        while (last != this.last && last.next != this.last ) {
            middle = middle.next;
            last = last.next.next;
        }

        if (last == this.last) return new int[]{middle.value};
        else return new int[]{middle.value, middle.next.value};
    }
    public boolean hasLoop() {
        Node slow, fast;
        slow = fast = first;

        while (fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}






















