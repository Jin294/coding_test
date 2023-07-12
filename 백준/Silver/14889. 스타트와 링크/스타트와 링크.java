import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, min, half;
    static int[][] matrix;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        half = n / 2;
        matrix = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        min = Integer.MAX_VALUE;
        recursion(0, 0);
        System.out.println(min);
    }

    // true : start, false : link
    // 부분집합
    private static void recursion(int depth, int count) {
        // 한 팀이 half명 이상이 되면 리턴
        if (depth == n) {
            return;
        }

        // 한 팀이 half명 일때만
        if (count == half) {
            min = Math.min(getDiff(), min);
            return;
        }

        visited[depth] = true;
        recursion(depth + 1, count + 1);
        visited[depth] = false;
        recursion(depth + 1, count);
    }

    private static int getDiff() {
        int team_start = 0;
        int team_link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    team_start += matrix[i][j];
                    team_start += matrix[j][i];
                } else if (!visited[i] && !visited[j]) {
                    team_link += matrix[i][j];
                    team_link += matrix[j][i];
                }
            }
        }
        return Math.abs(team_link - team_start);
    }
}