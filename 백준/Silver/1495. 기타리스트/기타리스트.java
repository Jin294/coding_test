import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[] volume = new int[number + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= number; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[number + 1][max + 1];
        dp[0][start] = true;
        for (int i = 1; i < number + 1; i++) {
            for (int j = 0; j < max + 1; j++) {
                // 접근 가능한 수라면
                if (dp[i - 1][j]) {
                    if (j - volume[i] >= 0) {
                        dp[i][j - volume[i]] = true;
                    }

                    if (j + volume[i] <= max) {
                        dp[i][j + volume[i]] = true;
                    }
                }
            }
        }

        int answer = -1;
        for (int i = max; i >= 0; i--) {
            if (dp[number][i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}