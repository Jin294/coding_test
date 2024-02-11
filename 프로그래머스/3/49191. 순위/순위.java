import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] matrix = new boolean[n + 1][n + 1];
        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            
            matrix[win][lose] = true;
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int winCnt = countWin(n, i, matrix, new boolean[n + 1]) - 1;
            int loseCnt = countLose(n, i, matrix, new boolean[n + 1]) - 1;
            
            if (winCnt + loseCnt + 1 == n) {
                answer++;
            }
        }       
        
        return answer;
    }
    
    public int countWin(int n, int now, boolean[][] matrix, boolean[] visited) {
        int count = 1;
        
        for (int i = 1; i <= n; i++) {
            // now가 i랑 싸워서 졌거나, 이미 방문한 적이 있다면
            if (!matrix[now][i] || visited[i]) {
                continue;
            }
            
            visited[i] = true;
            count += countWin(n, i, matrix, visited);
        }
        
        return count;
    }
    
    public int countLose(int n, int now, boolean[][] matrix, boolean[] visited) {
        int count = 1;
        
        for (int i = 1; i <= n; i++) {
            // now가 i랑 싸워서 졌거나, 이미 방문한 적이 있다면
            if (!matrix[i][now] || visited[i]) {
                continue;
            }
            
            visited[i] = true;
            count += countLose(n, i, matrix, visited);
        }
        
        return count;
    }
}