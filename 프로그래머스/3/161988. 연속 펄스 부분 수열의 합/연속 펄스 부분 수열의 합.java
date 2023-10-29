import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;

        // 펄스 배열 만들기
        int[] plus = new int[len];
        int[] minus = new int[len];
        int num = 1;
        for (int i = 0; i < len; i++) {
            plus[i] = num * sequence[i];
            num *= -1;
            minus[i] = num * sequence[i];
        }
        
        // dp 배열 만들기
        long[] dp1 = new long[len];
        long[] dp2 = new long[len];
        dp1[0] = plus[0];
        dp2[0] = minus[0];
        long result = Math.max(dp1[0], dp2[0]);
        
        for (int i = 1; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 1] + plus[i], plus[i]);
            dp2[i] = Math.max(dp2[i - 1] + minus[i], minus[i]);
            
            result = Math.max(result, Math.max(dp1[i], dp2[i]));
        }

        return Math.max(result, Math.max(dp1[len - 1], dp2[len - 1]));
    }
}