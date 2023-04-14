import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int[][] board;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			board = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				board[b][a] = 1;
			}
			
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && board[i][j] == 1) {
						DFS(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}

	private static void DFS(int row, int col) {
		
		visited[row][col] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = row + dy[i];
			int nx = col + dx[i];
			
			if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
				continue;
			}
			
			if (!visited[ny][nx] && board[ny][nx] == 1) {
				DFS(ny, nx);
			}
		}
	}
}