class Solution {
    static int[] gInfo;
    static int[][] gEdges;
    static int maxSheep;
    
    static final int SHEEP = 0;
    static final int WOLF = 1;
    
    public int solution(int[] info, int[][] edges) {
        gInfo = info;
        gEdges = edges;
        
        boolean[] visited = new boolean[info.length];
        DFS(0, 0, 0, visited);
        
        return maxSheep;
    }
    
    public void DFS(int now, int sheepCnt, int wolfCnt, boolean[] visited) {
        if (gInfo[now] == SHEEP) {
            sheepCnt++;
        } else {
            wolfCnt++;
        }
        visited[now] = true;
        
        if (sheepCnt <= wolfCnt) {
            return;
        }
        
        maxSheep = Math.max(maxSheep, sheepCnt);
        
        for (int[] edges : gEdges) {
            int parent = edges[0];
            int child = edges[1];
            
            // 부모는 방문했고 아이는 방문하지 않았다면
            if (visited[parent] && !visited[child]) {
                boolean[] nextVisited = new boolean[visited.length];
                for (int i = 0; i < nextVisited.length; i++) {
                    nextVisited[i] = visited[i];
                }
                
                DFS(child, sheepCnt, wolfCnt, nextVisited);
            }
        }
    }
}