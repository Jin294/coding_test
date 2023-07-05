import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] d = {{-1, 0}, {1, 0},  {0, -1}, {0, 1}};
    static int[][] matrix, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(answer[i], -1);
        }

        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 0) {
                    answer[i][j] = 0;
                } else if (matrix[i][j] == 2) {
                    start[0] =  i;
                    start[1] =  j;
                    answer[i][j] = 0;
                }
            }
        }

        BFS(start);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void BFS(int[] start) {

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + d[i][0];
                int nx = now[1] + d[i][1];

                if (ny >= n || ny < 0 || nx >= m || nx < 0) {
                    continue;
                }

                if (matrix[ny][nx] != 0 && answer[ny][nx] == -1) {
                    answer[ny][nx] = answer[now[0]][now[1]] + 1;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}