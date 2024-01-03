import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 진출지점 기준으로 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        // 카메라 위치 초기화
        int camera = -30_001;
        int answer = 0;
        
        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}