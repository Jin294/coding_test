import java.util.*;

class Solution {
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, 1, 0, -1};
    static int row, col;
    static String[] gBoard;
    static boolean[][] visited;
    public int solution(String[] board) {
        // 문자열 배열 전역화
        gBoard = board;
        
        // 행열길이 저장
        row = board.length;
        col = board[0].length();
        
        // 도달가능여부 확인하기 위해 방문체크 부울배열 생성
        visited = new boolean[row][col];
        
        // row, col, cnt(최소이동횟수)
        int[] start = new int[3];
        int[] goal = new int[3];
        
        // 시작위치 및 종료위치 기록
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i].charAt(j) == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        // BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                int[] now = q.poll();

                int r = now[0];
                int c = now[1];
                if (r == goal[0] && c == goal[1]) {
                    return now[2];
                }

                for (int j = 0; j < 4; j++) {
                    int nr = r + moveY[j];
                    int nc = c + moveX[j];
                    while (isVaild(nr, nc) && !isObstacle(nr, nc)) {
                        nr += moveY[j];
                        nc += moveX[j];
                    }
                    
                    nr -= moveY[j];
                    nc -= moveX[j];
                    
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc, now[2] + 1});
                    }
                }
            }
        }
        
        return -1;
    }
    
    public boolean isVaild(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
    
    public boolean isObstacle(int r, int c) {
        return gBoard[r].charAt(c) == 'D';
    }
}