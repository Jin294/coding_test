import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1; // 초깃값

        for (int i = 2; i <= n; i++) {
            dp[i] = i; // 아무리 많아봐야 i를 넘지 않는다.
            for (int j = 1; j * j <= i; j++) { // 1부터 i보다 작은 제곱수를 모두 탐색
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}