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
        
        int s = targets[0][0];
        int e = targets[0][1];
        
        for (int[] target : targets)  {
            int ns = target[0];
            int ne = target[1];
            
            if (ns >= e) {
                s = ns;
                e = ne;
                answer++;
            }
        }
        
        return answer;
    }
}