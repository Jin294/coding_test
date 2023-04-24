import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = max > arr[i] ? max : arr[i];
		}
		
		int[] nums = new int[max + 1];
		for (int i = 0; i < n; i++) {
			nums[arr[i]]++;
		}
		
		int answer = 0;
		for (int i = 1; i <= max; i++) {
			if (nums[i] == 0) {
				continue;
			}
			
			int weight = i * n;
			answer = answer > weight ? answer : weight;
			n -= nums[i];
		}
		
		System.out.println(answer);
	}
	
}