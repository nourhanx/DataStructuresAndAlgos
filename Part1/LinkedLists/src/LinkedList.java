public class LinkedList {
    private  Node first = null;
    private Node last = null;
    private int size;

    LinkedList(int val) {
        first = last = new Node(val);
        size = 1;
    }

    public void addFirst(int val) {
        Node temp = new Node(val);
        temp.setNext(first);
        first = temp;
        size++;
    }

    public void addLast(int val) {
        size++;
        Node node = new Node(val);
        if (first == null) {
            first = last = node;
            return;
        }

        last.setNext(node);
        last = node;
    }

    public void deleteFirst() {
        size--;
        if (first == null) {
            return;
        }
        first = first.getNext();
    }

    public void deleteLast(){
        if (first == null) {
            return;
        }

        size--;

        if (first == last) {
            first = last = null;
            return;
        }
        Node temp = first;
        Node curr = temp;

        while (temp.getNext() != null) {
            curr = temp;
            temp = temp.getNext();
        }
        last = curr;
        curr.setNext(null);
    }

    public boolean contains(int val) {
        if (first == null) {
            return false;
        }
        Node temp = first;
        while (temp != null) {
            if (temp.getValue() == val)
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    public int indexOf(int val) {
        if (first == null) {
            return -1;
        }
        Node temp = first;
        int index = 0;
        while (temp != null) {
            if (temp.getValue() == val)
                return index;
            temp = temp.getNext();
            index++;
        }
        return -1;
    }

    public void print() {
        if (first == null) {
            return;
        }
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        Node temp = first;
        int index = 0;
        while(temp != null) {
            arr[index] = temp.getValue();
            temp = temp.getNext();
            index++;
        }
        return arr;
    }
}
