import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leastNumberOfBills(35)));
    }

    public static int[] leastNumberOfBills(int amount) {
        int[] bills = {200, 100, 50, 20, 10, 5};
        int[] numBills = new int[6];
        int num;

        for (int i = 0; i < bills.length; i++) {
            num = 0;
            while (amount >= bills[i]) {
                amount = amount - bills[i];
                num ++;
            }
            numBills[i] = num;
        }
        return numBills;
    }
}