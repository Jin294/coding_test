import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int location;
        int distance;

        public Point(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }
    }
    static int n, maxDistance, destination, cnt;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        getDist();
        System.out.println(destination + " " + maxDistance + " " + cnt);
    }

    // BFS
    private static void getDist() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));
        visited = new boolean[n + 1];
        visited[1] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int now = cur.location;
            int distance = cur.distance;

            if (distance > maxDistance) {
                maxDistance = distance;
                destination = now;
                cnt = 1;
            } else if (distance == maxDistance) {
                destination = Math.min(destination, now);
                cnt++;
            }

            ArrayList<Integer> list = graph.get(cur.location);

            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    visited[list.get(i)] = true;
                    q.add(new Point(list.get(i), cur.distance + 1));
                }
            }
        }
    }
}