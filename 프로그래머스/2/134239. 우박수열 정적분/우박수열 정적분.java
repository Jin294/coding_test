// 1. 우박수열을 구한다.
// 2. 정적분한다.
// 3. 최종계산
import java.util.*;

class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        // 우박수열 구하기
        list.add(k);
        getNum(k);
        
        // 정적분 : 구간 넓이 구하기
        int n = list.size() - 1; // 5
        double[] area = new double[list.size()];
        double[] dp = new double[list.size()];
        for (int i = 1; i < area.length; i++) {
            area[i] = (list.get(i) + list.get(i - 1)) / 2.0;
            dp[i] = area[i] + dp[i - 1];
        }
        
        // 최종계산
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = ranges[i][1];
            
            if (n + end > n || n + end < start) {
                answer[i] = -1;
            } else {
                double sum = dp[n + end] - dp[start];
                answer[i] = sum;
            }
            
        }
        
        return answer;
    }
    
    public void getNum(int now) {
        int result = 0;
        if (now % 2 == 0) {
            result = now / 2;
        } else {
            result = now * 3 + 1;
        }
        
        list.add(result);
        if (result > 1) {
            getNum(result);
        }
        
    }
}