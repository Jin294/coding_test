import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        // 펄스 만들기
        int[] one = new int[sequence.length];
        int[] two = new int[sequence.length];
        
        int pulse = 1;
        for (int i = 0; i < sequence.length; i++) {
            one[i] = sequence[i] * pulse;
            pulse *= -1;
            two[i] = sequence[i] * pulse;
        }
        
        long[] dpA = new long[sequence.length];
        long[] dpB = new long[sequence.length];
        
        dpA[0] = one[0];
        dpB[0] = two[0];
        long answer = Math.max(dpA[0], dpB[0]);
        
        for (int i = 1; i < sequence.length; i++) {
            dpA[i] = Math.max(dpA[i-1] + one[i], one[i]);
            dpB[i] = Math.max(dpB[i-1] + two[i], two[i]);
            
            long max = Math.max(dpA[i], dpB[i]);
            answer = Math.max(answer, max);
        }
        
        return answer;
    }
}