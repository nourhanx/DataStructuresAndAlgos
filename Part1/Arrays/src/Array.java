public class Array {
    private int[] arr;
    private int count = 0;

    Array (int count) {
        arr = new int[count];
    }
    
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }
    public void insert(int el) {
        resizeIfRequired();
        arr[count++] = el;
    }
    public void insertAt(int el, int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException();
        }

        resizeIfRequired();

        for (int i = count; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = el;
        count++;
    }
    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        count--;
    }
    public int indexOf(int num) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
    public int maxAt() {
        if (count <= 0) {
            return -1;
        }

        int max  = arr[0];
        for (int i = 1; i < count; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public int minAt() {
        if (count <= 0) {
            return -1;
        }

        int min = arr[0];
        for (int i = 1; i < count; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public Array intersect(Array arr2) {
        Array intersection = new Array(count);
        for (int i = 0; i < count; i++) {
            if (arr2.indexOf(arr[i]) >= 0){
                intersection.insert(arr[i]);
            }
        }
        return intersection;
    }

    public void reverse(){
        int[] arrCopy = new int[arr.length];
        for (int i = 0; i < count; i++) {
            arrCopy[i] = arr[count - i - 1];
        }
        arr = arrCopy;
    }

    public void resizeIfRequired(){
        if (count == arr.length) {
            int[] arrCopy = new int[count * 2];
            for (int i = 0; i < arr.length; i++) {
                arrCopy[i] = arr[i];
            }
            arr = arrCopy;
        }
    }

}
