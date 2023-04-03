import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        br.close();
        int answer = 0;

        int res = n - 9 * s.length();

        while (n > res) {
            int tmp = res;
            int sum = 0;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (n != res + sum) {
                res++;
            } else {
                answer = res;
                break;
            }
        }

        System.out.println(answer);
    }
}