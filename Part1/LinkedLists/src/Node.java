class Node {
    private int value;
    private Node next;

    Node () {
        value = 0;
        next = null;
    }
    Node(int val){
        value = val;
        next = null;
    }
    Node getNext() {
        return next;
    }
    int getValue() {
        return value;
    }
    void setNext(Node n) {
        next = n;
    }
    void setValue(int val) {
        value = val;
    }
}
