import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            int len = str.length();

            int num = (int) Math.pow(10, len - 1);

            for (int j = 0; j < len; j++) {
                alphabet[str.charAt(j) - 'A'] += num;
                num /= 10;
            }
        }

        Arrays.sort(alphabet);

        int answer = 0;

        for (int i = 25; i >= 17; i--) {
            answer += alphabet[i] * (i - 16);
        }
        System.out.println(answer);
    }
}