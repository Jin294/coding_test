import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{ // 간선 클래스
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
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // 1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 이차원 리스트로 그래프 구현
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, value));
        }

        // 출발지로부터의 거리 저장하는 배열 dist
        int[] dist = new int[V + 1];
        // 방문여부 체크하는 visited
        boolean[] visited = new boolean[V + 1];
        // 정점간의 최솟값을 구하기 위해, 초깃값은 최댓값으로 채운다
        Arrays.fill(dist, INF);

        // BFS + 우선순위큐
        // 자동적으로 거리가 최소인 노드를 선택하기 위해
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 출발지 넣음
        pq.add(new Edge(start, 0));
        // 출발지 - 출발지 거리는 당연히 0
        dist[start] = 0;

        while (!pq.isEmpty()) {
            // 현재위치 now
            Edge now = pq.poll();

            if (visited[now.vertex]) {
                continue;
            }

            // 중복방문 막기위해 방문체크
            visited[now.vertex] = true;

            ArrayList<Edge> list = graph.get(now.vertex);
            for (Edge next : list) {
                if (dist[next.vertex] > dist[now.vertex] + next.value) {
                    // 최솟값 경신 : (도착지까지의 거리, 현재위치 + 간선값)
                    dist[next.vertex] = dist[now.vertex] + next.value;
                    // q에 넣는다
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }

        // 경로가 없다면 INF
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }
}