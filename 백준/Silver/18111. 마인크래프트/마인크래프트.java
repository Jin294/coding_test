import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int min = 256;
        int max = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }

        long time = Integer.MAX_VALUE;
        long h = 0;
        
        // 최솟값부터 최댓값까지
        for (int i = min; i <= max; i++) {
            long cnt = 0;
            long block = b;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int diff = board[j][k] - i;
                    if (diff > 0) { // 깎아내야 할 때
                        cnt += diff * 2;
                        block += diff;
                    } else { // 채워넣어야 할 때
                        cnt -= diff;
                        block += diff;
                    }
                }
            }

            // 필요한 블록 개수가 주어진 블록 개수보다 클 때
            if (block < 0) {
                break;
            }

            // 필요한 시간이
            if (time >= cnt) {
                time = cnt;
                h = i;
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(time).append(" ").append(h);
        System.out.println(sb);
    }
}