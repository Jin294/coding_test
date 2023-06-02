import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int end = 10_000;
        boolean[] nums = new boolean[end + 1];
        for (int i = 1; i < nums.length; i++) {
            int num = i;
            char[] arr = String.valueOf(num).toCharArray();
            for (int j = 0; j < arr.length; j++) {
                num += arr[j] - '0';
            }
            if (num <= end) {
                nums[num] = true;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (!nums[i]) {
                System.out.println(i);
            }
        }
    }
}