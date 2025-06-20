import java.util.Arrays;

public class QuickSort {
    public static void main (String[] args) {
        int[] arr = {3,5,8,1,3,0,9};
        int k = 1;
        int minSum = 0;
        int maxSum = 0;
        int i;

        quickSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        for (i = k; i < arr.length ; i++) {
            maxSum += arr[i];
        }
        for (i = 0; i < arr.length - k; i++) {
            minSum += arr[i];
        }

        System.out.println("minimum sum is " + minSum);
        System.out.println(("maximum sum is " + maxSum));



    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int i = left;
        int j = right;
        int pivot = arr[left + (right - left) / 2];

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // left i j right
        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }



//    // swap
//    static void swap(int[] arr, int i, int j) {
//        int temp;
//        temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//// quick sort
//    static void quickSort(int[] arr, int left, int right) {
//        if (left >= right) return;
//
//        int i = left;
//        int j = right;
//        int pivot = arr[left + (right - left) / 2];
//
//        while (i <= j) {
//            while (arr[i] < pivot) i++;
//            while (arr[j] > pivot) j--;
//
//            if (i <= j) {
//                swap(arr, i, j);
//                i++;
//                j--;
//            }
//        }
//
//        if (left < j) quickSort(arr, left, j);
//        if (i < right) quickSort(arr, i, right);
//    }
}
