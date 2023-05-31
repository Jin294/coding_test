import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Site{
        int y;
        int x;
        int count;

        public Site(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    // {y, x}
    static int n;
    static int[][] go = {{2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Site now = new Site(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            st = new StringTokenizer(br.readLine());
            Site target = new Site(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            boolean[][] visited = new boolean[n][n];
            BFS(now, target, visited);
        }
    }

    private static void BFS(Site now, Site target, boolean[][] visited) {
        Queue<Site> q = new LinkedList<>();
        q.add(now);

        while (!q.isEmpty()) {
            Site out = q.poll();
            visited[out.y][out.x] = true;

            if (out.x == target.x && out.y == target.y) {
                System.out.println(out.count);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int ny = out.y + go[i][0];
                int nx = out.x + go[i][1];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new Site(ny, nx, out.count + 1));
                }
            }
        }
    }
}