import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, answer;
    static char[][] board;
    // 하우
    static int[][] d = {{1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        answer = 0;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        check();
        // 개수가 n과 같다면 더 이상 진행할 필요 없음 -> 중단
        if (answer == n){
            System.out.println(n);
        } else {
            go();
            System.out.println(answer);
        }
    }

    private static void go() {
        // swap horizontal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {

                if (board[i][j] != board[i][j + 1]) {
                    swap(i, j, i, j + 1);

                    check();
                    if(answer == n) {
                        return;
                    }

                    swap(i, j, i, j + 1);
                }
            }
        }

        // swap vertical
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {

                if (board[j][i] != board[j + 1][i]) {
                    swap(j, i, j + 1, i);

                    check();
                    if(answer == n) {
                        return;
                    }

                    swap(j, i, j + 1, i);
                }
            }
        }
    }

    private static void swap(int row, int col, int nRow, int nCol) {
        char tmp = board[row][col];
        board[row][col] = board[nRow][nCol];
        board[nRow][nCol] = tmp;
    }

    private static void check() {
        // count horizontal
        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                } else {
                    answer = answer < count ? count : answer;
                    count = 1;
                }
            }

            answer = answer < count ? count : answer;

            // 개수가 n과 같다면 더 이상 진행할 필요 없음 -> 중단
            if (count == n) {
                return;
            }
        }

        // count vertical
        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                } else {
                    answer = answer < count ? count : answer;
                    count = 1;
                }
            }

            answer = answer < count ? count : answer;

            // 개수가 n과 같다면 더 이상 진행할 필요 없음 -> 중단
            if (count == n) {
                return;
            }
        }
    }
}