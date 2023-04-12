import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 0;
        int lt = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            while (sum > m) {
                sum -= nums[lt++];
            }

            if (sum == m) {
                count++;
                sum -= nums[lt++];
            }
        }

        System.out.println(count);
    }
}