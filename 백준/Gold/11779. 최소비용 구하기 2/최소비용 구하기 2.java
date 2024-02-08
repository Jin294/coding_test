import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int vertex;
    int value;

    public Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

public class Main {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dist, p;
    static boolean[] visited;
    static int minDist = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, val));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        p = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;

        dijkstra(A);
        System.out.println(dist[B]);

        ArrayList<Integer> routes = new ArrayList<>();
        int parent = B;
        while (parent != 0) {
            routes.add(parent);
            parent = p[parent];
        }

        System.out.println(routes.size());
        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.vertex]) {
                continue;
            }

            visited[now.vertex] = true;

            ArrayList<Edge> list = graph.get(now.vertex);
            for (Edge next : list) {
                if (dist[next.vertex] > dist[now.vertex] + next.value) {
                    p[next.vertex] = now.vertex;
                    dist[next.vertex] = dist[now.vertex] + next.value;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }
    }
}