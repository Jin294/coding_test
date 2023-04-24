import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);
		
		int answer = 0;
		while(list.size() > 0) {
			int sum = list.get(0) * list.size();
			answer = answer > sum ? answer : sum;
			
			list.remove(0);
		}
		
		System.out.println(answer);
	}
	
}