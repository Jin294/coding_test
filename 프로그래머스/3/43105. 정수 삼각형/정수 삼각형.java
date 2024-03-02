import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] dp = new int[n][n];
        dp[n - 1] = triangle[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        
        return dp[0][0];
    }
}