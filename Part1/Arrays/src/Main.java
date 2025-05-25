public class Main {
    public static void main(String[] args) {

        Array arr = new Array(3);
        arr.insert(10);
        arr.insert(20);
        arr.insert(30);
        arr.removeAt(2);
        arr.print();
    }
}
