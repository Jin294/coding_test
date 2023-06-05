import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작점 기준으로 오름차순 정렬
        Arrays.sort(board, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int s = board[0][0];
        int e = board[0][1];
        int len = 0;
        // s - e : 현재 구간
        for (int i = 1; i < n; i++) {
            if (board[i][0] > e) {
                len += e - s;
                s = board[i][0];
                e = board[i][1];
            }

            if (board[i][0] < s) {
                s = board[i][0];
            }

            if (board[i][1] > e) {
                e = board[i][1];
            }

        }

        len += e - s;
        System.out.println(len);
    }
}