import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class IntFinder {

    public int mostFrequent(int[] arr) {
        int count = 0;

        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int el : arr) {
            count  = frequency.getOrDefault(el, 0);
            frequency.put(el, ++count);
        }

        int max = 0;
        int res = -1;
        int val;
        int cnt;

        for (var entry : frequency.entrySet()) {
            val = entry.getKey();
            cnt = entry.getValue();
            if ((cnt > max) || (cnt == max && val > res)) {
                max = cnt;
                res = val;
            }
        }
        return res;
    }

    public int countUniquePairsWithDiff(int[] arr, int k) {
        HashSet<Integer> unique = new HashSet<>();
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int complement;
        int count = 0;

        if (k == 0) {
            for (int el : arr) frequencies.put(el, frequencies.getOrDefault(el, 0) + 1);

            for (var entry : frequencies.entrySet()) {
                if (entry.getValue() > 1) count++;
            }
            return count;
        }
        for (int el : arr) {
            unique.add(el);
        }
        for (int el : unique) {
            complement = k + el;
            if (unique.contains(complement)) count++;
        }
        return count;
    }

    public int[] twoSum(int[] arr, int sum) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        int complement;

        for (int i = 0; i < arr.length; i++) {
            complement = sum - arr[i];
            if (indices.containsKey(complement)) return new int[]{indices.get(complement), i};
            indices.put(arr[i], i);
        }
        return null;
    }

    public static void main (String[] args) {
        IntFinder myFinder = new IntFinder();
        System.out.println(myFinder.mostFrequent(new int[]{1, 2, 2, 3, 3, 3, 4}));

        System.out.println(myFinder.countUniquePairsWithDiff(new int[]{1, 7, 5, 9, 9, 9, 2, 12, 3}, 0));

        System.out.println(Arrays.toString(myFinder.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}

