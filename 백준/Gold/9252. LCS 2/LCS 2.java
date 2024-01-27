import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();

        int m = x.length();
        int n = y.length();

        int[][] matrix1 = calculateLCSLength(x, y);
        System.out.println(matrix1[m][n]);

        int[][] matrix2 = calculateLCSRoute(matrix1, x, y);

        String LCS = getLCS(matrix2, m, n, x);
        System.out.println(LCS);
    }

    public static int[][] calculateLCSLength(String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] matrix = new int[m + 1][n + 1];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }

        return matrix;
    }

    public static int[][] calculateLCSRoute(int[][] dp, String x, String y) {
        int m = x.length();
        int n = y.length();

        int[][] matrix = new int[m + 1][n + 1];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = dp[i][j - 1] > dp[i - 1][j] ? 2 : 3;
                }
            }
        }

        return matrix;
    }

    public static String getLCS(int[][] route, int m, int n, String x) {
        if (m == 0 || n == 0) {
            return "";
        }

        int num = route[m][n];

        if (num == 1) {
            return getLCS(route, m - 1, n - 1, x) + x.charAt(m - 1);
        } else if (num == 2) {
            return getLCS(route, m, n - 1, x);
        } else {
            return getLCS(route, m - 1, n, x);
        }
    }
}