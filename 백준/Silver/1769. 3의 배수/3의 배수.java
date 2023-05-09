import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] ch = s.toCharArray();
		int x = 0;
		
		int count = 0;
		while (true) {
			int sum = 0;
			for (int i = 0; i < ch.length; i++) {
				sum += ch[i] - '0';
			}
			
			if (ch.length >= 2) {
				count++;
				s = String.valueOf(sum);
				ch = s.toCharArray();
			} else {
				x = sum;
				break;
			}
		}
		
		System.out.println(count);
		if (x != 0 && x % 3 == 0) System.out.println("YES");
		else System.out.println("NO");
	}
}