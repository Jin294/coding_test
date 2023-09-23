import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(solution(a, b, c));
    }

    private static long solution(long base, long times, long modulus) {
        if (modulus == 1) {
            return 0;
        }

        long result = 1L;

        base %= modulus;

        while (times > 0) {
            if (times % 2 == 1) {
                result = (result * base) % modulus;
            }
            times = times >> 1;
            base = (base * base) % modulus;
        }

        return result;
    }
}