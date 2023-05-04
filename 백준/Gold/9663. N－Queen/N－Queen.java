import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, count;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        recursion(0);
        System.out.println(count);
    }

    private static void recursion(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i;
            if (check(depth)) {
                recursion(depth + 1);
            }
        }
    }

    private static boolean check(int now) {
        for (int i = 0; i < now; i++) {
            if (board[now] == board[i]) return false;
            else if (Math.abs(board[i] - board[now]) == Math.abs(i - now)) return false;
        }

        return true;
    }
}