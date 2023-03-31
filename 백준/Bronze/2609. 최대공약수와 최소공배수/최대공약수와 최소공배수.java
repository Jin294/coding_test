import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = a > b ? a : b;
        int min = a < b ? a : b;
        int gcd = getGCD(max, min);
        System.out.println(gcd);
        System.out.println(max * min / gcd);
    }

    private static int getGCD(int max, int min) {
        if (max % min == 0) return min;
        return getGCD(min, max % min);
    }
}