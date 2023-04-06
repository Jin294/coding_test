import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, v;
	static boolean[] visited;
	
	static int[][] adjArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		adjArr = new int[n + 1][n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjArr[a][b] = 1;
			adjArr[b][a] = 1;
		}

		visited = new boolean[n + 1];
		DFS(v);
		System.out.println();
		BFS(v);
	}
	
	private static void BFS(int start) {
		visited = new boolean[n + 1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");
			
			for (int i = 0; i <= n; i++) {
				if (!visited[i] && adjArr[now][i] > 0) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

	private static void DFS(int target) {
		System.out.print(target + " ");
		visited[target] = true;
		
		for (int i = 0; i <= n; i++) {
			if (!visited[i] && adjArr[target][i] > 0) {
				DFS(i);
			}
		}
	}
}