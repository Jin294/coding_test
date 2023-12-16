// BFS로 방문체크하면서 더하기?
import java.util.*;

class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public int[] solution(String[] maps) {
        int len = maps.length;
        int len2 = maps[0].length();
        char[][] matrix = new char[len][len2];
        boolean[][] visited = new boolean[len][len2];
        for (int i = 0; i < maps.length; i++) {
            matrix[i] = maps[i].toCharArray();
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len2; j++) {
                if (!visited[i][j] && Character.isDigit(matrix[i][j])) {
                    int sum = 0;
                    q.add(new int[]{i, j});
                    
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        
                        int row = now[0];
                        int col = now[1];
                        visited[row][col] = true;
                        sum += matrix[row][col] - '0';
                        
                        for (int k = 0; k < 4; k++) {
                            int nr = row + dy[k];
                            int nc = col + dx[k];
                            
                            if ((nr < 0 || nc < 0 || nr >= len || nc >= len2))  {
                                continue;
                            }
                            
                            if (visited[nr][nc]) {
                                continue;
                            }
                            
                            if (Character.isDigit(matrix[nr][nc])) {
                                q.add(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    
                    list.add(sum);
                }
            }
        }
        
        if (list.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}