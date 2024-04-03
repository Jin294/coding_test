import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int now = -30_000;
        int cnt = 0;
        
        for (int[] route : routes) {
            // 진입지점은 현재보다 작을 때
            // 진출지점은 현재보다 클 때
            if (now < route[0] || route[1] < now) {
                cnt++;
                now = route[1];
            }
        }
        
        return cnt;
    }
}