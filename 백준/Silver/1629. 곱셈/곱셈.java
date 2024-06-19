import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, c;
    
    public static long divideAndConquer(int count) {
        if (count == 0) return 1;
        else if (count == 1) return a;

        long tmp = divideAndConquer(count / 2) % c;
        long ret = tmp * tmp % c;

        return count % 2 == 0 ? ret : ret * a % c;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            System.out.println(divideAndConquer(b) % c);
        }
    }
}