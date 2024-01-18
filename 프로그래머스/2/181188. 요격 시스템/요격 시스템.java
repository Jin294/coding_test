import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int answer = 1;
        
        int end = targets[0][1];
        
        for (int[] target : targets)  {
            int newStart = target[0];
            int newEnd = target[1];
            
            if (newStart >= end) {
                end = newEnd;
                answer++;
            }
        }
        
        return answer;
    }
}
