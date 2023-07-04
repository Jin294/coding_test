import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, min;
    static int[] peoples;
    static boolean[] selected, visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        peoples = new int[n + 1];
        selected = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        divide(1);
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }

    private static void divide(int depth) {
        if (depth == n + 1) {
            ArrayList<Integer> one = new ArrayList<>();
            ArrayList<Integer> two= new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (selected[i]) {
                    one.add(i);
                } else {
                    two.add(i);
                }
            }

            if (one.size() == 0 || two.size() == 0) {
                return;
            }

            if (check(one) && check(two)) {
                getDiff();
            }

            return;
        }

        selected[depth] = true;
        divide(depth + 1);
        selected[depth] = false;
        divide(depth + 1);
    }

    private static boolean check(ArrayList<Integer> list) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n + 1];
        visited[list.get(0)] = true;
        q.add(list.get(0));

        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int y = graph.get(cur).get(i);
                if(list.contains(y) && !visited[y]) {
                    q.add(y);
                    visited[y] = true;
                    count ++;
                }
            }
        }

        return count == list.size();
    }

    private static void getDiff() {
        int one = 0, two = 0;
        for (int i = 1; i <= n; i++) {
            if (selected[i])
                one += peoples[i];
            else
                two += peoples[i];
        }

        min = Math.min(min, Math.abs(one - two));
    }
}