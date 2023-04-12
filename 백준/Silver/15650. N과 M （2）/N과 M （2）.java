import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        recursion(0, 0);
        System.out.println(sb);
    }

    private static void recursion(int depth, int num) {
        if (depth == m) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sb.append(i + 1).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = num; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recursion(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}