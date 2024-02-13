import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] answer = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer[i] = BFS(i);
            min = Math.min(min, answer[i]);
        }

        for (int i = 1; i<= n; i++) {
            if (answer[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }

    public static int BFS(int now) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        q.add(now);
        visited[now] = true;
        int d = 0;

        while (!q.isEmpty()) {
            int size= q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                dist[cur] = d;

                ArrayList<Integer> list = graph.get(cur);
                for (int j = 0; j < list.size(); j++) {
                    int target = list.get(j);
                    if (!visited[target]) {
                        visited[target] = true;
                        q.add(target);
                    }
                }
            }
            d++;
        }

        return Arrays.stream(dist).sum();
    }
}