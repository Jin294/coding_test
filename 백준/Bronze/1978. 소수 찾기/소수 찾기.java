import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
		}
		
		boolean[] visited = new boolean[1001];
		visited[1] = true;
		for (int i = 2; i <= 1000; i++) {
			if (visited[i]) continue;
			
			for (int j = i; i * j <= 1000; j++) {
				visited[i * j] = true;
			}
		}
		
		Iterator<Integer> itr = set.iterator();
		int answer = 0;
		while (itr.hasNext()) {
			if (!visited[itr.next()]) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}