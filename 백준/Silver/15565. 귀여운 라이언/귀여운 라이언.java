import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(st.nextToken()) == 1) {
				list.add(i);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size() + 1 - k; i++) {
			int tmp = list.get(i + k - 1) - list.get(i);
			min = min < tmp ? min : tmp; 
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min + 1);
		}
	}
}