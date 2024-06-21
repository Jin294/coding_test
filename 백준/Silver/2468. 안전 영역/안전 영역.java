import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] matrix;
    static boolean[][] visited;

    public static boolean isInRange(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }

    public static void DFS(int y, int x, int curLevel) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isInRange(ny, nx) && !visited[ny][nx] && matrix[ny][nx] > curLevel) {
                DFS(ny, nx, curLevel);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int min = 100;
        int max = 1;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 데이터 입력
            n = Integer.parseInt(br.readLine());
            matrix = new int[n][n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());

                    // 최소, 최대높이 업데이트
                    min = Math.min(min, matrix[i][j]);
                    max = Math.max(max, matrix[i][j]);
                }
            }
        };

        // 모든 지역이 물에 잠기는 것을 감안해서 최솟값을 1로 설정함.
        int answer = 1;

        // 좌표 이동을 위한 배열
        for (int level = min; level <= max; level++) {
            int count = 0;
            visited = new boolean[n][n];

            // 이차원 배열 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 물에 잠기지 않았으면서 방문하지 않은 곳
                    if (matrix[i][j] > level && !visited[i][j]) {
                        DFS(i, j, level);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}