import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        int[] arr = list.toArray();

        list.print();

        System.out.println("---------------------");

        System.out.println(list.contains(3));
        System.out.println(list.indexOf(4));
        System.out.println("Size = " + list.getSize());
        System.out.println(Arrays.toString(arr));

        System.out.println("---------------------");

        list.deleteFirst();
        list.deleteLast();

        list.print();
        System.out.println("Size = " + list.getSize());
    }
}