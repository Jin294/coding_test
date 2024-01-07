// 최종적으로 루트가 두 가지 밖에 없기는 한데
// 문제는 주어지는 사각형들이 합쳐진 다각형의 최외각 테두리를 어떻게 구하냐가 문제
// 안쪽 공간을 다 칠해버린 다음 테두리만 남기고 비우자
import java.util.*;

class Solution {
    static int[][] gRectangle, matrix;
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, 1, 0, -1};
    static boolean[][] visited;
    static final int LEN = 100;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        matrix = new int[LEN + 1][LEN + 1];
        visited = new boolean[LEN + 1][LEN + 1];
        gRectangle = rectangle;
        
        for (int i = 0; i < rectangle.length; i++) {
            fillRectangle(rectangle[i]);
        }
        for (int i = 0; i < rectangle.length; i++) {
            clearRectangle(rectangle[i]);
        }
        matrix[itemY * 2][itemX * 2] = 2;
        
        return BFS(characterY, characterX);
    }
    
    public int BFS(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y * 2, x * 2});
        
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] now = q.poll();
                
                if (matrix[now[0]][now[1]] == 2) {
                    return dist / 2;
                }
                visited[now[0]][now[1]] = true;
                                
                for (int j = 0; j < 4; j++) {
                    int nr = now[0] + moveY[j];
                    int nc = now[1] + moveX[j];

                    if ((nr >= 0 && nc >= 0 && nr <= LEN && nc <= LEN) && matrix[nr][nc] != 0 && !visited[nr][nc]) {
                        
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            
            dist++;
        }
        
        return 0;
    }
    
    public void fillRectangle(int[] points) {
        int xStart = points[0] * 2;
        int xEnd = points[2] * 2;
        
        int yStart = points[1] * 2;
        int yEnd = points[3] * 2;
        
        for (int i = yStart; i <= yEnd; i++) {
            for (int j = xStart; j <= xEnd; j++) {
                matrix[i][j] = 1;
            }
        }
    }
    
    public void clearRectangle(int[] points) {
        int xStart = points[0] * 2;
        int xEnd = points[2] * 2;
        
        int yStart = points[1] * 2;
        int yEnd = points[3] * 2;
        
        for (int i = yStart + 1; i < yEnd; i++) {
            for (int j = xStart + 1; j < xEnd; j++) {
                matrix[i][j] = 0;
            }
        }
    }
}