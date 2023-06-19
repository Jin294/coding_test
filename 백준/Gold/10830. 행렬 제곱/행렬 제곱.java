import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[][] A2B, A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        A = new long[n][n];
        A2B = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A2B[i][j] = A[i][j] = Long.parseLong(st.nextToken()) % 1000;
            }
        }

        long[][] answer = div(b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static long[][] div(long b) {
        if (b == 1) {
            return A;
        }

        long[][] memo = div(b / 2);

        if (b % 2 == 0) {
            return multiple(memo, memo);
        } else {
            return multiple(multiple(memo, memo), A);
        }
    }

    public static long[][] multiple(long[][] one, long[][] two){
        long[][] tmp = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = go(i, j, one, two);
            }
        }

        for (int i = 0; i < n; i++) {
            A2B[i] = tmp[i].clone();
        }

        return tmp;
    }

    public static long go(int row, int col, long[][] one, long[][] two){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += one[row][i] * two[i][col];
        }
        return sum % 1000;
    }
}