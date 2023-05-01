import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] s;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (!str.equals("0")) {
            StringTokenizer st = new StringTokenizer(str);
            k = Integer.parseInt(st.nextToken());
            s = new int[k];
            visited = new boolean[k];
            for (int j = 0; j < k; j++) {
                s[j] = Integer.parseInt(st.nextToken());
            }

            recursion(0, 0);
            System.out.println();
            str = br.readLine();
        }
    }

    private static void recursion(int idx, int count) {
        if (count == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    System.out.print(s[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        if (idx == k) {
            return;
        }

        visited[idx] = true;
        recursion(idx + 1, count + 1);
        visited[idx] = false;
        recursion(idx + 1, count);
    }
}