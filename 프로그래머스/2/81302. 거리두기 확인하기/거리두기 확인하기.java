import java.util.*;

class Solution {
    final int D = 2;
    int[] moveY = {1, -1, 0, 0};
    int[] moveX = {0, 0, 1, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean checkRoom(String[] place) {
        char[][] matrix = new char[5][5];
        for (int i = 0; i < 5; i++) {
            matrix[i] = place[i].toCharArray();
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == 'P') {
                    if(!BFS(matrix, i, j)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean BFS(char[][] matrix, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        
        q.add(new int[]{row, col, 0});
        visited[row][col] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + moveY[i];
                int nc = now[1] + moveX[i];
                
                // 범위 초과, 방문경험, 거리 2이상이면 패스
                if (!isRangeIn(nr, nc) || visited[nr][nc] || now[2] >= 2) {
                    continue;
                }
                
                if (matrix[nr][nc] == 'P') {
                    return false;
                }
                
                visited[nr][nc] = true;
                
                // 파티션은 못넘는다 => 큐에 담지 않음
                if (matrix[nr][nc] == 'X') {
                    continue;
                }
                
                q.add(new int[]{nr, nc, now[2] + 1});
            }
        }
        
        // 현재 응시자와 맨해튼거리가 2 이하인 사람은 없음
        return true;
    }
    
    public boolean isRangeIn(int row, int col) {
        return row >= 0 && col >= 0 && row < 5 && col < 5;
    }
}