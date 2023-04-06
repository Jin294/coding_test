import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.get(s).add(e);
            list.get(e).add(s);
        }

        visited = new boolean[n + 1];
        check(1);
        int answer = 0;
        for (boolean item : visited) {
            if (item) {
                answer++;
            }
        }

        System.out.println(answer - 1);
    }

    public static void check(int num) {
        if (visited[num]) {
            return;
        }

        visited[num] = true;
        ArrayList<Integer> tmp = list.get(num);
        for (int j = 0; j < tmp.size(); j++) {
            check(tmp.get(j));
        }
    }
}
