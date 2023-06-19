import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, answer;
    static int[][] matrix, calculation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        matrix = new int[n][m];
        calculation = new int[k][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                calculation[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[k];
        int[] order = new int[k];
        solution(visited, order, 0);
        System.out.println(answer);
    }

    private static void solution(boolean[] visited, int[] order, int depth) {
        if (depth == k) {
            go(order);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                solution(visited, order, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void go(int[] order) {
        int[][] copyMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMatrix[i] = matrix[i].clone();
        }

        for (int i = 0; i < k; i++) {
            int[] calc = calculation[order[i]];
            gogo(copyMatrix, calc);
        }

        for (int i = 0; i < n; i++) {
            answer = Math.min(Arrays.stream(copyMatrix[i]).sum(), answer);
        }
    }

    private static int[][] gogo(int[][] copyMatrix, int[] calc) {
        int s = calc[2];
        int r = calc[0] - 1;
        int c = calc[1] - 1;

        return input(copyMatrix, s, r, c);
    }

    private static int[][] input(int[][] copyMatrix, int s, int r, int c) {
        Deque<Integer> deque = new LinkedList<>();
        while (s != 0) {
            // 테두리 상
            for (int i = c - s; i <= c + s; i++) {
                deque.add(copyMatrix[r - s][i]);
            }
            // 테두리 우
            for (int i = r - s + 1; i <= r + s; i++) {
                deque.add(copyMatrix[i][c + s]);
            }
            // 테두리 하
            for (int i = c + s - 1; i >= c - s; i--) {
                deque.add(copyMatrix[r + s][i]);
            }
            // 테두리 좌
            for (int i = r + s - 1; i >= r - s + 1; i--) {
                deque.add(copyMatrix[i][c - s]);
            }

            deque.addFirst(deque.pollLast());

            // 테두리 상
            for (int i = c - s; i <= c + s; i++) {
                copyMatrix[r - s][i] = deque.pollFirst();
            }
            // 테두리 우
            for (int i = r - s + 1; i <= r + s; i++) {
                copyMatrix[i][c + s] = deque.pollFirst();
            }
            // 테두리 하
            for (int i = c + s - 1; i >= c - s; i--) {
                copyMatrix[r + s][i] = deque.pollFirst();
            }
            // 테두리 좌
            for (int i = r + s - 1; i >= r - s + 1; i--) {
                copyMatrix[i][c - s] = deque.pollFirst();
            }

            s--;
        }

        return copyMatrix;
    }
}