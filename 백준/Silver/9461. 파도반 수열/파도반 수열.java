import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] arr = new long[101];
		arr[1] = arr[2] = arr[3] = 1;
		for (int i = 4; i < arr.length; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[n] + "\n");
		}
		System.out.println(sb);
	}
}