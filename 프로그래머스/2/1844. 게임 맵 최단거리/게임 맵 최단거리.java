import java.util.*;

class Solution {
    // 북, 동, 남, 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    public int solution(int[][] maps) {
        int answer = -1;
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            
            if (isGoal(tmp[0], tmp[1])) {
                answer = tmp[2];
                break;
            }
            
            visited[tmp[0]][tmp[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nr = tmp[0] + dy[i];
                int nc = tmp[1] + dx[i];
                int cnt = tmp[2] + 1;
                
                if (isIn(nr, nc) && canGo(maps, nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, cnt});
                }
            }
        }
        
        return answer;
    }
    
    public boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    
    public boolean canGo(int[][] maps, int row, int col) {
        return maps[row][col] == 1;
    }
    
    public boolean isGoal(int row, int col) {
        return row == n - 1 && col == m - 1;
    }
}