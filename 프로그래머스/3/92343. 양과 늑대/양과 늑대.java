import java.util.*;

class Solution {
    static int[] gInfo;
    static int[][] gEdges;
    
    static boolean[] visited;
    
    static final int SHEEP = 0;
    static int answer;
    public int solution(int[] info, int[][] edges) {
        gInfo = info;
        gEdges = edges;
        
        visited = new boolean[info.length];
        
        DFS(0, 0, 0);
        
        return answer;
    }
    
    public void DFS(int now, int sheepCnt, int wolfCnt) {
        if (gInfo[now] == SHEEP) {
            sheepCnt++;
        } else {
            wolfCnt++;
        }
                
        if (sheepCnt <= wolfCnt) {
            return;
        }
        answer = Math.max(answer, sheepCnt);
        
        visited[now] = true;
        
        for (int[] edge : gEdges) {
            int p = edge[0];
            int c = edge[1];
            
            if (visited[p] && !visited[c]) {
                DFS(c, sheepCnt, wolfCnt);
            }
        }
        
        visited[now] = false;
    }
}