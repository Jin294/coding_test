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
		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		
		int answer = 1;
		int min = (n < m ? n : m) - 1;
		outer : for (int size = min; size >= 1; size--) {
				
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < m; col++) {
					if (col + size < m && row + size < n) {
						if (board[row][col] == board[row][col + size]
							&& board[row][col] == board[row + size][col]
							&& board[row][col]== board[row + size][col + size]) {
							answer = size + 1;
							break outer;
						}
					}
				}
			}
		}
		
		System.out.println(answer * answer);
	}
}