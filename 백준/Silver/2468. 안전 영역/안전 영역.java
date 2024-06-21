import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static boolean isRangeWithin(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }

    public static void main(String[] args) throws IOException {
        int min = 100;
        int max = 1;
        int[][] matrix;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 데이터 입력
            n = Integer.parseInt(br.readLine());
            matrix = new int[n][n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    min = Math.min(min, matrix[i][j]);
                    max = Math.max(max, matrix[i][j]);
                }
            }
        };

        int answer = 1;

        // 좌표 이동을 위한 배열
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Queue<int[]> q;
        boolean[][] visited;
        for (int level = min; level <= max; level++) {
            int count = 0;
            q = new LinkedList<>();
            visited = new boolean[n][n];

            // 이차원 배열 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 물에 잠기지 않았으면서 방문하지 않은 곳
                    if (matrix[i][j] > level && !visited[i][j]) {
                        visited[i][j] = true;
                        q.add(new int[]{i, j});

                        // 현제 높이에서 침수되지 않은 곳의 개수 세는 변수
                        count++;

                        // BFS로 level 이하 높이인 지역의 개수 세기
                        while (!q.isEmpty()) {
                            int[] now = q.poll();

                            for (int k = 0; k < 4; k++) {
                                int ny = now[0] + dy[k];
                                int nx = now[1] + dx[k];

                                // 1. 범위체크, 2. 방문여부 체크, 3. 침수여부 체크
                                if (isRangeWithin(ny, nx) && !visited[ny][nx] && matrix[ny][nx] > level) {
                                    visited[ny][nx] = true;
                                    q.add(new int[]{ny, nx});
                                }
                            }
                        }
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}