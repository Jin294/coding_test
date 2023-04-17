import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            nums[i] = (char) (x - 'a') + 1;
        }

        long answer = 0;
        long cnt = 1L;
        for (int i = 0; i < n; i++) {
            answer += cnt * nums[i];
            cnt *= 31L;
        }
        System.out.println(answer);
    }
}