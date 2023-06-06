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

        // 개수가 n과 같다면 더 이상 진행할 필요 없음 -> 중단
        if (check() == n){
            System.out.println(n);
        } else {
            go();
            System.out.println(answer);
        }
    }

    private static void go() {
        // swap
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                for (int k = 0; k < 2; k++) {
                    // 이동한 new 좌표
                    int ny = i + d[k][0];
                    int nx = j + d[k][1];

                    // 범위 벗어나면 패스
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n){
                        continue;
                    }

                    // 스왑 조건 : 타겟 칸과 달라야 한다.
                    if (board[i][j] != board[ny][nx]) {
                        // 스왑
                        swap(i, j, ny, nx, board[i][j], board[ny][nx]);

                        // 개수가 n과 같다면 더 이상 진행할 필요 없음 -> 중단
                        if (check() == n) {
                            return;
                        }

                        // 원래대로 되돌린다.
                        swap(i, j, ny, nx, board[i][j], board[ny][nx]);
                    }
                }
            }
        }
    }

    private static void swap(int i, int j, int ny, int nx, char original, char nw) {
        char tmp = original;
        board[i][j] = nw;
        board[ny][nx] = tmp;
    }

    private static int check() {
        // 가로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char target = board[i][j];

                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (target == board[i][k]) {
                        count++;
                    } else {
                        answer = answer < count ? count : answer;
                        count = 0;
                    }
                }
                answer = answer < count ? count : answer;
                // 개수가 n과 같다면 더 이상 진행할 필요 없음 -> 중단
                if (answer == n) return n;
            }
        }

        // 세로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char target = board[j][i];

                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (target == board[k][i]) {
                        count++;
                    } else {
                        answer = answer < count ? count : answer;
                        count = 0;
                    }
                }
                answer = answer < count ? count : answer;
                // 개수가 n과 같다면 더 이상 진행할 필요 없음 -> 중단
                if (answer == n) return n;
            }
        }

        return answer;
    }
}