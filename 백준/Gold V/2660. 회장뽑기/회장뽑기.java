import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] dist;
    static ArrayList<Integer> result;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[n + 1][n + 1];
        result = new ArrayList<>();

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            BFS(i);
            scores[i] = Arrays.stream(dist[i]).max().getAsInt();
            min = Math.min(min, scores[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (scores[i] == min) {
                result.add(i);
            }
        }

        System.out.println(min + " " + result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void BFS(int now) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(now);
        visited[now] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            ArrayList<Integer> list = graph.get(cur);
            for (int j = 0; j < list.size(); j++) {
                int num = list.get(j);
                if (!visited[num]) {
                    visited[num] = true;
                    dist[now][num] = dist[now][cur] + 1;
                    q.add(num);
                }
            }
        }
    }
}