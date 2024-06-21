import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, size;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] matrix;
    static boolean[][] visited;
    static ArrayList<Integer> list;

    public static boolean isInRange(int y, int x) {
        return y >= 0 && x >= 0 && y < m && x < n;
    }

    public static void DFS(int y, int x) {
        size++;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isInRange(ny, nx) && !visited[ny][nx] && matrix[ny][nx] == 0) {
                DFS(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            matrix = new int[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                for (int row = y1; row < y2; row++) {
                    for (int col = x1; col < x2; col++) {
                        matrix[row][col]++;
                    }
                }
            }
        };

        list = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    size = 0;
                    DFS(i, j);
                    answer++;
                    list.add(size);
                }
            }
        }

        Collections.sort(list);
        System.out.println(answer);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}