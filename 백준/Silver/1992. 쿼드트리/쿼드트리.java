import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] matrix;
    static Queue<String> q;

    public static boolean isAllSame(int row, int col, int size) {
        int target = matrix[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (matrix[i][j] != target) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void recursion(int row, int col, int size) {
        if (isAllSame(row, col, size)) {
            q.offer(String.valueOf(matrix[row][col]));
            return;
        }

        int nSize = size / 2;
        q.offer("(");
        recursion(row, col, nSize);
        recursion(row, col + nSize, nSize);
        recursion(row + nSize, col, nSize);
        recursion(row + nSize, col + nSize, nSize);
        q.offer(")");
    }


    public static void main(String[] args) throws IOException {
        // 데이터 입력
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                char[] arr = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = arr[j] - '0';
                }
            }
        };

        q = new LinkedList<>();
        recursion(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (String x : q) {
            sb.append(x);
        }
        System.out.println(sb);
    }
}