import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int row;
    int col;
    int cnt;

    public Point(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}

public class Main {
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 데이터 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        // 좌표 이동을 위한 배열
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        // 방문처리를 위한 부울배열 : 같은 곳 재방문안하게 체크
        boolean[][] visited = new boolean[n][m];
        
        // BFS : 넓이우선탐색
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            // 목적지에 다다르면 프로그램 종료
            if (cur.row == n - 1 && cur.col == m - 1) {
                System.out.println(cur.cnt);
                return;
            }

            visited[cur.row][cur.col] = true;

            for (int i = 0; i < 4; i++) {
                int nr = cur.row + dy[i];
                int nc = cur.col + dx[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc] && matrix[nr][nc] != 0) {
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc, cur.cnt + 1));
                    }
                }
            }
        }

    }
}