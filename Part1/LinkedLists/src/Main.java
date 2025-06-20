import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(3);
        list.deleteFirst();
//        list.addFirst(2);
//        list.addFirst(1);
//        list.addLast(4);
//        list.addLast(5);
//        list.addLast(6);
//        list.addLast(7);
//        list.addLast(8);
//        list.addLast(9);
//        list.addLast(10);
        int[] arr = list.toArray();

        list.print();

        System.out.println("---------------------");

        System.out.println(Arrays.toString(list.printMiddle()));

//        System.out.println(list.contains(3));
//        System.out.println(list.indexOf(4));
//        System.out.println("Size = " + list.getSize());
//        System.out.println(Arrays.toString(arr));

//        System.out.println("---------------------");
//
//        list.reverse();
//        list.print();

//        System.out.println("---------------------");
//
//        list.recursiveReverse();
//        list.print();
//
//        System.out.println("---------------------");
//
//        list.deleteFirst();
//        list.print();
//        list.deleteLast();
//        list.print();
//        System.out.println("Size = " + list.getSize());
//
//        System.out.println("---------------------");
//
//        LinkedList emptyList = new LinkedList();
//        System.out.println(Arrays.toString(emptyList.toArray()));
//        System.out.println(emptyList.indexOf(30));


    }
}