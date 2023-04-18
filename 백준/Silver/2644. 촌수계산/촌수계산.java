import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> family;
    static boolean[] visited;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        family = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            family.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            family.get(a).add(b);
            family.get(b).add(a);
        }

        recursion(1, from, to);
        System.out.println(answer);
    }

    private static void recursion(int depth, int now, int target) {
        visited[now] = true;

        ArrayList<Integer> list = family.get(now);
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)] && list.get(i) == target) {
                answer = depth;
                visited[list.get(i)] = true;
                return;
            } else if (!visited[list.get(i)]) {
                recursion(depth + 1, list.get(i), target);
            }
        }
    }
}