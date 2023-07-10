import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int loc;
        int val;

        public Point(int loc, int val) {
            this.loc = loc;
            this.val = val;
        }
    }
    static int n;
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

        int max = getDist();
        ArrayList<Integer> answer = findLoc(max);
        Collections.sort(answer);
        System.out.println(answer.get(0) + " " + max + " " + answer.size());
    }

    // 1로부터 해당 지점까지의 거리 계산
    private static int getDist() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));
        visited = new boolean[n + 1];
        visited[1] = true;

        int max = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            ArrayList<Integer> list = graph.get(now.loc);
            max = Math.max(max, now.val);
            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    visited[list.get(i)] = true;
                    q.add(new Point(list.get(i), now.val + 1));
                }
            }
        }

        return max;
    }

    private static ArrayList<Integer> findLoc(int len) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));
        visited = new boolean[n + 1];
        visited[1] = true;

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Point now = q.poll();
            ArrayList<Integer> list = graph.get(now.loc);

            if (now.val == len) {
                result.add(now.loc);
            }

            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    visited[list.get(i)] = true;
                    q.add(new Point(list.get(i), now.val + 1));
                }
            }
        }

        return result;
    }

}