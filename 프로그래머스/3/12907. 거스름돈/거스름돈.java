import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        // 돈의 액수만큼 배열 생성
        int[][] dp = new int[money.length + 1][n + 1];
        // 화폐 크기 순으로 오름차순 정렬
        Arrays.sort(money);

        // 0원을 만드는 방법은
        // "어떠한 화폐도 사용하지 않음" 이라는 한 가지 방법이 있으므로
        // 초깃값 1로 설정
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (j < money[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i - 1]]) % 1_000_000_007;
                    }
                }
            }
        }

        return dp[money.length][n];
    }
}