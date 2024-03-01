import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static final int INF = (int) Math.pow(10, 6);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, INF);
        arr[n] = 0;

        for (int i = n; i > 1; i--) {
            if (arr[i] != INF)  {
                if (i % 3 == 0) {
                    add(arr, i, i / 3);
                }

                if (i % 2 == 0) {
                    add(arr, i, i / 2);
                }

                add(arr, i, i - 1);
            }
        }

        System.out.println(arr[1]);
    }

    public static void add(int[] arr, int first, int second) {
        arr[second] = Math.min(arr[second], arr[first] + 1);
    }
}