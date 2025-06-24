import java.util.ArrayList;

public class BST {
    // Node class
    private class Node {
        private int value;
        private Node leftChild = null;
        private Node rightChild = null;

        Node(int value) {
            this.value = value;
        }
        public boolean hasLeftChild() {
            return this.leftChild != null;
        }
        public boolean hasRightChild() {
            return this.rightChild != null;
        }
        public boolean isLeaf() {
            return !hasLeftChild() && !hasRightChild();
        }
        @Override
        public String toString() {
            return Integer.valueOf(value).toString();
        }
    }
    private Node root = null;
    // insert
    public void insert(int val) {
        if (empty()) {
            root = new Node(val);
            return;
        }
        Node current = root;
        Node newNode = new Node(val);
        while (true) {
            if (val > current.value)
            {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            } else if (val < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else break;
        }
    }
    // find
    public boolean find (int val) {
        if (empty()) throw new IllegalStateException("Tree is empty");
        Node current = root;
        while (current !=  null) {
            if (val > current.value) current  = current.rightChild;
            else if (val < current.value) current = current.leftChild;
            else return true;
        }
        return false;
    }
    public boolean empty() {
        return root == null;
    }
    public void preOrderTraverse() {
        inOrderTraverse(root);
    }
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }
    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    public void preOrderTraverse (Node root) {
        if (root == null) return;
        System.out.println(root);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    private void inOrderTraverse (Node root) {
        if (root == null) return;
        inOrderTraverse(root.leftChild);
        System.out.println(root);
        inOrderTraverse(root.rightChild);
    }

    private void postOrderTraverse (Node root) {
        if (root == null) return;
        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.println(root);
    }

//    public int height() {
//        return height(root);
//    }

//    private int height(Node root) {
//        if (root == null) return -1;
//        if (root.isLeaf())
//            return 0;
//        return (1 + Math.max(
//                height(root.leftChild),
//                height(root.rightChild)));
//    }
    public int min(){
        return min(root);
    }
//    private int min(Node root) {
//        if (root == null) return -1;
//        if (root.isLeaf()) {
//            return root.value;
//        }
//        return min(root.leftChild);
//    }
    private int min(Node root) {
        if (root == null) return -1;
        if (root.isLeaf()) {
            return root.value;
        }
        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return (Math.min(Math.min(left, right), root.value));
    }
    public boolean equals(BST other) {
        if (other == null) return false;
        return equals(root, other.root);
    }
    private boolean equals (Node first, Node second) {
//        if (first.isLeaf() && second.isLeaf()) return true;
        if (first == null && second == null) return true;
        else if (first != null && second != null) {
            return first.value == second.value &&
                    equals(first.leftChild, second.leftChild) &&
                    equals(first.rightChild, second.rightChild);
        }
        else return false;
    }

    public boolean isBst() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(Node root, int min, int max) {
        if (root == null) return true;
        return (root.value > min && root.value < max) &&
                isBst(root.leftChild, min, root.value) &&
                isBst(root.rightChild, root.value, max);
    }

    public void swapRoot() {
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public ArrayList<Integer> getNodesAtK (int k) {
        if (k < 0) throw new IllegalArgumentException("Enter a positive value");
        ArrayList<Integer> nodes = new ArrayList<>();
        getNodesAtK(k, root, nodes);
        return nodes;
    }
    private void getNodesAtK(int k, Node root, ArrayList<Integer> nodes) {
        if (root == null) return;
        if (k == 0) {
            nodes.add(root.value);
            return;
        }
        getNodesAtK(k - 1, root.leftChild, nodes);
        getNodesAtK(k - 1, root.rightChild, nodes);
    }

    public int height() {
        return height(root);
    }
    private int height(Node root) {
        if (root == null) return  -1;
        if (root.isLeaf()) return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }
    public void printNodesAtK(int k) {
        if (root == null) throw new IllegalStateException("Empty tree");
        printNodesAtK(k, root);
    }
    private void printNodesAtK(int k, Node root) {
        if (root == null) return;
        if (k == 0) {
            System.out.println(root);
            return;
        }
        printNodesAtK(k - 1, root.leftChild);
        printNodesAtK(k - 1, root.rightChild);
    }
    public void levelOrderTraverse(){
        for (int i = 0; i <= height(); i++) {
            printNodesAtK(i);
        }
    }
    public int size() {
        return size(root);
    }
    private int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.leftChild) +size(root.rightChild);
    }
    public int sumLeaves() {
        return sumLeaves(root);
    }
    private int sumLeaves(Node root) {
        if (root == null) return 0;
        if (root.isLeaf()) return root.value;
        return sumLeaves(root.leftChild) + sumLeaves(root.rightChild);
    }
    public int max() {
        return max(root);
    }
    private int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = max(root.leftChild);
        int rightMax = max(root.rightChild);

        return Math.max(root.value, Math.max(leftMax, rightMax));
    }
    public boolean contains(int x){
        return contains(x, root);
    }
    private boolean contains (int x, Node root) {
        if (root == null) return false;
        if (root.value == x) return true;
        return contains(x, root.leftChild) ||
                contains(x, root.rightChild);
    }
    public boolean areSiblings (int x, int y) {
        return areSiblings(x, y, root);
    }
    private boolean areSiblings (int x, int y, Node root) {
        if (root == null || root.isLeaf()) return false;
        if (root.leftChild != null && root.rightChild != null) {
            if ((root.leftChild.value == x && root.rightChild.value == y) ||
                    (root.leftChild.value == y && root.rightChild.value == x))
                return true;
        }
        return areSiblings(x, y, root.leftChild) || areSiblings(x, y, root.rightChild);
    }
    public ArrayList<Integer> getAncestors(int x) {
        ArrayList<Integer> ancestors = new ArrayList<>();
        getAncestors(x, root, ancestors);
        return ancestors;
    }
    private boolean getAncestors(int x, Node root, ArrayList<Integer> ancestors) {
        if (root == null) return false;

        if (root.value == x)
            return true;

        if (getAncestors(x, root.leftChild, ancestors) ||
                getAncestors(x, root.rightChild, ancestors)) {
            ancestors.add(root.value);
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        BST tree = new BST();
        BST other = new BST();

        // Insert values
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);
        tree.insert(20);

        other.insert(10);
        other.insert(5);
//        other.insert(15);
        other.insert(3);
        other.insert(7);
        other.insert(12);
        other.insert(18);
        other.insert(20);

//        System.out.println(tree.height());
//        System.out.println(tree.equals(other));
//        tree.swapRoot();
//        System.out.println(tree.isBst());
//        tree.preOrderTraverse();
//        tree.inOrderTraverse();
//        tree.postOrderTraverse();

//        System.out.println(tree.getNodesAtK(1));
        tree.levelOrderTraverse();
        // Find existing values
//        System.out.println(tree.find(10));  // true
//        System.out.println(tree.find(5));   // true
//        System.out.println(tree.find(15));  // true
//        System.out.println(tree.find(3));   // true
//        System.out.println(tree.find(7));   // true
//        System.out.println(tree.find(12));  // true
//        System.out.println(tree.find(18));  // true
//
//        // Find non-existing values
//        System.out.println(tree.find(0));   // false
//        System.out.println(tree.find(6));   // false
//        System.out.println(tree.find(20));  // false
    }

}
