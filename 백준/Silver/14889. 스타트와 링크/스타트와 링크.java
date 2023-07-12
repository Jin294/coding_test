import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, min, half;
    static int[][] matrix;
    static boolean[] visited;
    static ArrayList<Integer> one, two;
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
        recursion(0, 0, 0);
        System.out.println(min);
    }

    // true : start, false : link
    // 부분집합
    private static void recursion(int depth, int start, int link) {
        // 한 팀이 half명 이상이 되면 리턴
        if (start > half || link > half) {
            return;
        }

        if (depth == n) {
            // 각 팀이 half명 일때만
            if (start == half && link == half) {
                one = new ArrayList<>();
                two = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        one.add(i);
                    } else {
                        two.add(i);
                    }
                }

                int sum1 = getSum(one);
                int sum2 = getSum(two);
                min = Math.min(min, Math.abs(sum1 - sum2));
            }
            return;
        }

        visited[depth] = true;
        recursion(depth + 1, start + 1, link);
        visited[depth] = false;
        recursion(depth + 1, start, link + 1);
    }

    private static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    sum += matrix[list.get(i)][list.get(j)];
                }
            }
        }
        return sum;
    }
}