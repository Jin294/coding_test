import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(str[i - 1]);
        }
        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[j] + arr[i - j], dp[i]);
            }
            dp[i] = Math.max(dp[i], arr[i]);
        }
        System.out.println(dp[n]);
    }
}