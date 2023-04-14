import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            int rank = 1;
            int[] target = board[i];
            for (int j = 0; j < board.length; j++) {
                int[] tmp = board[j];
                if (i != j) {
                    if (target[0] < tmp[0] && target[1] < tmp[1]) {
                        rank++;
                    }
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}