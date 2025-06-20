public class TwoStacks {
    int size = 10;
    int[] stacks;
    int top1 = 0;
    int top2 = size - 1;

    TwoStacks() {
        stacks = new int[size];
    }

    public void push1(int element) {
        if (top1 == top2) resize();
        stacks[top1++] = element;
    }

    public void push2(int element) {
        if (top1 == top2) resize();
        stacks[top2--] = element;
    }

    public int pop1() {
        if (isEmpty1()) throw new IllegalStateException("Stack 1 is empty");
        return stacks[--top1];
    }

    public int pop2() {
        if (isEmpty2()) throw new IllegalStateException("Stack 2 is empty");
        return stacks[++top2];
    }

    public void resize(){
        int oldSize = size;
        size *= 2;
        int[] newStacks = new int[size];
        for (int i = 0; i < top1; i++) {
            newStacks[i] = stacks[i];
        }
        for (int i = 0; i < count2(); i++) {
            newStacks[size - 1 - i] = stacks[oldSize - 1 - i];
        }
        stacks = newStacks;
        top2 = size - count2();
    }

    public boolean isEmpty1() {
        return top1 == 0;
    }

    public boolean isEmpty2() {
        return top2 == size - 1;
    }

    public int count1() {
        return top1;
    }

    public int count2() {
        return size - top2 - 1;
    }

    public void print1() {
        for (int i = 0; i < top1; i++) {
            System.out.println(stacks[i]);
        }
    }

    public void print2() {
        for (int i = size - 1; i > top2; i--) {
            System.out.println(stacks[i]);
        }
    }

    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks();

        // Push elements to stack1
        ts.push1(10);
        ts.push1(20);
        ts.push1(30);

        // Push elements to stack2
        ts.push2(100);
        ts.push2(200);
        ts.push2(300);

        System.out.println("Size of stack 1 = " + ts.count1());
        System.out.println("Size of stack 2 = " + ts.count2());

        // Print both stacks
        System.out.println("Stack 1:");
        ts.print1(); // should print 10, 20, 30

        System.out.println("Stack 2:");
        ts.print2(); // should print 300, 200, 100

        // Pop from both stacks
        System.out.println("Pop from Stack 1: " + ts.pop1()); // 30
        System.out.println("Pop from Stack 2: " + ts.pop2()); // 300

        // Print again after pop
        System.out.println("Stack 1 after pop:");
        ts.print1(); // should print 10, 20

        System.out.println("Stack 2 after pop:");
        ts.print2(); // should print 200, 100

        // Check if either stack is empty
        System.out.println("Is Stack 1 empty? " + ts.isEmpty1()); // false
        System.out.println("Is Stack 2 empty? " + ts.isEmpty2()); // false

        // Empty stacks completely
        ts.pop1(); // 20
        ts.pop1(); // 10
        ts.pop2(); // 200
        ts.pop2(); // 100

        System.out.println("Is Stack 1 empty after full pop? " + ts.isEmpty1()); // true
        System.out.println("Is Stack 2 empty after full pop? " + ts.isEmpty2()); // true
    }
}
