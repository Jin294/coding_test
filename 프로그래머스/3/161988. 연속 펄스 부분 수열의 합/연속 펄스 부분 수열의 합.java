import java.util.*;

class Solution {
    static int len;
    static long[] dp1, dp2;
    public long solution(int[] sequence) {
        len = sequence.length;
        
        // 배열 길이만큼 펄스 수열 만듦
        int[] plus = makePulse(1, -1);
        int[] minus = makePulse(-1, 1);
        
        // dp 만들기
        dp1 = makeArrayDynamic(sequence, plus);
        dp2 = makeArrayDynamic(sequence, minus);
        
        return Math.max(getMax(dp1), getMax(dp2));
    }
    
    public long getMax(long[] dp) {
        // 최대인 인덱스 찾기
        int idx = 0;
        long max = dp[idx];
        for (int i = 0; i < len; i++) {
            if (max < dp[i]) {
                max = dp[i];
                idx = i;
            }
        }
        
        for (int i = 0; i < idx; i++) {
            max = Math.max(max, dp[idx] - dp[i]);
        }
        
        return max;
    }
    
    public long[] makeArrayDynamic(int[] sequence, int[] arr) {
        long[] dp = new long[len];
        
        dp[0] = sequence[0] * arr[0];
        for (int i = 1; i < len; i++) {
            dp[i] += (long) dp[i - 1] + (long) (sequence[i] * arr[i]);
        }
        
        return dp;
    }
    
    public int[] makePulse(int first, int second) {
        int[] arr = new int[len];
        
        for (int i = 0; i < len; i++) {
            arr[i] = (i % 2 == 0) ? first : second;
        }
        
        return arr;
    }
}