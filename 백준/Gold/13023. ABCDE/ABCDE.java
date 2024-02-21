import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(0, i);
                if (answer == 1) {
                    break;
                }
                visited[i] = false;
            }
        }

        System.out.println(answer);
    }

    private static void DFS(int depth, int now) {
        if (depth == 4) {
            answer = 1;
            return;
        }

        ArrayList<Integer> list = graph.get(now);
        for (int i = 0; i < list.size(); i++) {
            int target = list.get(i);
            if (!visited[target]) {
                visited[target] = true;
                DFS(depth + 1, list.get(i));
                visited[target] = false;
            }
        }
    }
}