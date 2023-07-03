import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final String STAIR = "use the stairs";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[f + 1];
        System.out.println(BFS(arr, f, s, g, u, d));
    }

    private static String BFS(int[] arr, int floor, int start, int goal, int up, int down) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        arr[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == goal) {
                return String.valueOf(arr[now] - 1);
            }

            int upside = now + up;
            int downside = now - down;

            if (upside <= floor && arr[upside] == 0) {
                arr[upside] = arr[now] + 1;
                q.add(upside);
            }

            if (downside > 0 && arr[downside] == 0) {
                arr[downside] = arr[now] + 1;
                q.add(downside);
            }
        }

        return STAIR;
    }
}