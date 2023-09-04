import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int answer = 0;
    static List<List<Integer>> two;
    static int[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        two = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            two.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            two.get(a).add(b);
            two.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new int[n];
            if (answer == 1) {
                break;
            } else {
                dfs(i, 0);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int x, int depth) {
        if (depth == 4) {
            answer = 1;
            return;
        }

        visited[x] = 1;
        for (int i = 0; i < two.get(x).size(); i++) {
            if (visited[two.get(x).get(i)] == 0) {
                dfs(two.get(x).get(i), depth + 1);
                if (answer == 1) return;
            }
        }
        visited[x] = 0;
    }
}