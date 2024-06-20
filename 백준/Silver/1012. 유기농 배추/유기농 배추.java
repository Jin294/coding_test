import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 좌표 이동을 위한 배열
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static boolean[][] matrix, visited;
    static int n, m;

    public static boolean isRangeWithin(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static void DFS(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nr = row + dy[i];
            int nc = col + dx[i];

            // 범위 안에 해당되는가
            if (isRangeWithin(nr, nc)) {
                if (matrix[nr][nc] &&!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    DFS(nr, nc);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 데이터 입력
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                matrix = new boolean[n][m];
                for (int i = 0; i < k; i++) {
                    st = new StringTokenizer(br.readLine());
                    int col = Integer.parseInt(st.nextToken());
                    int row = Integer.parseInt(st.nextToken());

                    matrix[row][col] = true;
                }

                // 방문처리를 위한 부울배열 : 같은 곳 재방문안하게 체크
                visited = new boolean[n][m];

                int count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (matrix[i][j] && !visited[i][j]) {
                            visited[i][j] = true;
                            DFS(i, j);
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        }
    }
}