import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 삼각형 크기 n
		int n = Integer.parseInt(br.readLine());
		// 삼각형을 담을 이차원 배열 선언
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		
		StringTokenizer st;
		// 삼각형을 입력받는다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = arr[0][0];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + arr[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j]; 
				}
			}
		}
		
		System.out.println(Arrays.stream(dp[n - 1]).max().getAsInt());
	}
}