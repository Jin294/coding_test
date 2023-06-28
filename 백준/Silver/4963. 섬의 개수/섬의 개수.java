import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] matrix;
    static boolean[][] visited;
    static int w, h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (!input.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            matrix = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (matrix[i][j] == 1 && !visited[i][j]) {
                        DFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
            input = br.readLine();
        }
    }

    private static void DFS(int row, int col) {
        for (int i = 0; i < 8; i++) {
            int ny = row + dy[i];
            int nx = col + dx[i];

            if (ny < 0 || nx < 0 || ny >= h || nx >= w) {
                continue;
            }

            if (matrix[ny][nx] == 1 && !visited[ny][nx]) {
                visited[ny][nx] = true;
                DFS(ny, nx);
            }
        }
    }
}