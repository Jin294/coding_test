import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) {
                add(dp, i, i / 3);
            }

            if (i % 2 == 0) {
                add(dp, i, i / 2);
            }
        }

        System.out.println(dp[n]);
    }

    public static void add(int[] arr, int now, int next) {
        arr[now] = Math.min(arr[now], arr[next] + 1);
    }
}