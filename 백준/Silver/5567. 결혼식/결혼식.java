import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        ArrayList<Integer> first = list.get(1);
        for (int i = 0; i < first.size(); i++) {
            visited[first.get(i)] = true;

            ArrayList<Integer> second = list.get(first.get(i));
            for (int j = 0; j < second.size(); j++) {
                visited[second.get(j)] = true;
            }
        }

        int answer = 0;
        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}