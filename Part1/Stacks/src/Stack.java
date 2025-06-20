import java.util.Arrays;



public class Stack {
    int[] stack ;
    private int count = 0;

    Stack() {
        stack = new int[2];
    }
    public void push(int element) {
        if (count == stack.length) {
            int[] newStack = new int[2 * count];
            for(int i = 0; i < count; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }

        stack[count++] = element;
    }
    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack[--count];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return stack[count - 1];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count  == 0);
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(stack, 0, count);
        return(Arrays.toString(content));
    }
    public void print() {
        for (int i = count - 1; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.isEmpty());
        System.out.println("The peek result is " + myStack.peek());
        System.out.println("The pop result is " + myStack.pop());
        System.out.println(myStack);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.isEmpty());
//        myStack.pop(); // throws IllegalStateException


    }
}
