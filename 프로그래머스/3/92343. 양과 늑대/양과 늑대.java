import java.util.*;

class Solution {
    static int[] gInfo;
    static int[][] gEdges;
    
    static int answer;
    static final int SHEEP = 0;
    static final int WOLF = 1;
    public int solution(int[] info, int[][] edges) {
        gInfo = info;
        gEdges = edges;
        
        DFS(0, 0, 0, new boolean[info.length]);
        
        return answer;
    }
    
    public void DFS(int now, int sheepCnt, int wolfCnt, boolean[] isVisited) {
        if (gInfo[now] == SHEEP) {
            sheepCnt++;
        } else {
            wolfCnt++;
        }
        
        if (sheepCnt <= wolfCnt) {
            return;
        }
                
        isVisited[now] = true;
        answer = Math.max(answer, sheepCnt);
        
        for (int[] edge : gEdges) {
            int parent = edge[0];
            int child = edge[1];
            
            if (isVisited[parent] && !isVisited[child]) {
                boolean[] nextVisited = new boolean[gInfo.length];
                for (int i = 0; i < nextVisited.length; i++) {
                    nextVisited[i] = isVisited[i];
                }
                
                DFS(child, sheepCnt, wolfCnt, nextVisited);
            }
        }
    }
}