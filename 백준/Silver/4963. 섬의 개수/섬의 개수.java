import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static boolean[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (!input.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            matrix = new boolean[h + 2][w + 2];
            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++) {
                    matrix[i][j] = st.nextToken().charAt(0) > '0';
                }
            }

            int count = 0;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (matrix[i][j]) {
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

            if (matrix[ny][nx]) {
                matrix[ny][nx] = false;
                DFS(ny, nx);
            }
        }
    }
}